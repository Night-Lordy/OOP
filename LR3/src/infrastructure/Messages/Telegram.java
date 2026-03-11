package infrastructure.Messages;

import models.Order;

public class Telegram extends Messages {
    public Telegram(String server) {
        super(server);
    }

    @Override
    public void SendMessage(Order order, double total) {
        String subject = "New order: " + order.getId();
        String body = String.format("New order received.\n* ID: %s\n* Amount: **%.2f**", order.getId(), total);

        System.out.printf(">> Message sent to manager chat (%s)\n   Subject: %s\n   Body: %s\n", super.getServer(), subject, body);
    }
}
