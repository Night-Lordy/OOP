package infrastructure.Messages;

import models.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLog extends Messages{
    public FileLog(String server) {
        super(server);
    }

    @Override
    public void SendMessage(Order order, double total){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = String.format("[%s] EVENT: ORDER_PROCESSED | TARGET: %s | DETAILS: Id=%s, Type=%s, Total=%.2f\n",
                timestamp, order.getClientEmail(), order.getId(), order.getType(), total);

        try {
            Files.writeString(Path.of(super.getServer()), logEntry,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println(">> [LOG] Event recorded in " + super.getServer());
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }
}
