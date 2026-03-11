import java.util.List;

import models.*;
import models.Cards.*;
import infrastructure.Database.*;
import infrastructure.Messages.*;
import staff.*;

/**
 * Точка входа в приложение.
 */
public class App {
    public static void main(String[] args) {
        // 1. Создание заказа
        var order = new Order(
                "ORD-256-X",
                "Premium",
                List.of(
                        new Item("1", "Thermal Clips", 1500),
                        new Item("2", "UNATCO Pass Card", 50)),
                "jeevacation@gmail.com",
                new Address("Agartha", "33 Thomas Street", "[REDACTED]"),
                new GoldCard() );

        //2. Добавить все сообщения
        var messages = List.of(
                new SmtpMailer("smtp.google.com"),
                new Telegram("@main_manager"),
                new FileLog("events.log")
        );

        // 3. БД с кэшированием
        AbstractDatabase db = new RandomSQLDatabase("random://root:password@localhost:228/shop");
        AbstractDatabase cachedDB = new Caching(db);

        // 4. Инициализация процессора
        var processor = new OrderProcessor(cachedDB, messages);

        // 5. Обработка заказа
        try {
            processor.Process(order);
        } catch (Exception e) {
            System.out.println("Failed to process order: ");
            throw new RuntimeException(e);
        }

        // 6. Работа с обслуживанием
        System.out.println("\nTesting Warehouse Stuff:");
        List<WarehouseWorker> workers = List.of(
                new HumanManager(),
                new RobotPacker("George Droid"));

        Warehouse.manageWarehouse(workers);
    }
}
