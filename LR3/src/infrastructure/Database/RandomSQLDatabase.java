package infrastructure.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import models.Order;

/**
 * RandomSQLDatabase - имитация тяжелой базы данных
 */
public class RandomSQLDatabase extends AbstractDatabase{
    private String connectionString;

    public RandomSQLDatabase(String connectionStq) {
        this.connectionString = connectionString;
    }

    /**
     * Сохранение заказа в "базу данных"
     * 
     * @param order
     * @param total
     * @throws InterruptedException
     */
    @Override
    public void saveOrder(Order order, double total) throws InterruptedException{
        System.out.println("Connecting to Database at " + connectionString + " ...");
        Thread.sleep(500); // Имитация задержки сети

        var record = String.format("[%s] ID: %s | Type: %s | Total: %.2f\n",
                LocalDateTime.now().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_INSTANT), order.getId(),
                order.getType(), total);
        try {
            Files.writeString(Path.of("orders_db.txt"), record, StandardOpenOption.APPEND, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Order saved successfully.");
    }

    public String getConnectionString(){
        return connectionString;
    }
}
