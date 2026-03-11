package infrastructure.Messages;

import models.Order;

abstract public class Messages {
    private String server;

    public Messages(String server) {
        this.server = server;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public abstract void SendMessage(Order order, double total);
}