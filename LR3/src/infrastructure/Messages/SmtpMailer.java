package infrastructure.Messages;

import models.Order;

/**
 * SmtpMailer - имитация почтового сервиса
 */
public class SmtpMailer extends Messages {
    public SmtpMailer(String server) {
        super(server);
    }

    @Override
    public void SendMessage(Order order, double total) {
        var body = String.format("<h1>Your order %s is confirmed!</h1><p>Total: %.2f</p>", order.getId(), total);
        var subject = "Order Confirmation: " + order.getId();

        System.out.printf(">> Connecting to SMTP server %s...\n", super.getServer());
        System.out.printf(">> Sending EMAIL to %s\n   Subject: %s\n   Body: %s\n", order.getClientEmail(), subject, body);
    }
}