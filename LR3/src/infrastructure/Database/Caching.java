package infrastructure.Database;

import java.util.HashSet;
import java.util.Set;
import models.*;

public class Caching extends AbstractDatabase{
    private final AbstractDatabase baseRepository; // база данных
    private final Set<String> cache; // кэш в памяти

    public Caching(AbstractDatabase baseRepository) {
        this.baseRepository = baseRepository;
        this.cache = new HashSet<>();
    }

    @Override
    public void saveOrder(Order order, double total) throws InterruptedException {
        String orderId = order.getId();

        // 1. Проверяем кэш ДО обращения к БД
        if (cache.contains(orderId)) {
            System.out.println(">> [CACHE] Заказ " + orderId + " уже есть в кэше. Пропуск сохранения в БД.");
            return;
        }

        // 2. Если в кэше нет, вызываем метод сохранения у реальной БД
        baseRepository.saveOrder(order, total);

        // 3. После успешного сохранения ПОСЛЕ обращения к БД добавляем в кэш
        cache.add(orderId);
    }
}
