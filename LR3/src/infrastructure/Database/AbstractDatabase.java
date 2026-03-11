package infrastructure.Database;

import models.Order;

abstract public class AbstractDatabase {
    public abstract void saveOrder(Order order, double total) throws InterruptedException;
}
