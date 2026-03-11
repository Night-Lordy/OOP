import java.util.UUID;

class Transaction {
    public enum TransactionStatus {
        PENDING("pending..."),
        COMPLETED("completed"),
        FAILED("failed"),
        CANCELLED("cancelled");

        private String status;
        TransactionStatus(String status) { this.status = status; }
        public String getTransactionStatus() { return status; }
    }

    private String transactionId;
    private String fromAccount;
    private String toAccount;
    private double Sum;
    private String description;
    private TransactionStatus status;

    public Transaction(String fromAccount, String toAccount, double Sum, String description) {
        this.transactionId = UUID.randomUUID().toString().substring(0, 10);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.Sum = Sum;
        this.description = description;
        this.status = TransactionStatus.PENDING;
    }

    public void complete() {
        this.status = TransactionStatus.COMPLETED;
    }

    public void fail(String reason) {
        this.status = TransactionStatus.FAILED;
        this.description += " [FAILED: " + reason + "]";
    }

    public void cancel() {
        this.status = TransactionStatus.CANCELLED;
    }

    public String getStatus() {
        return status.getTransactionStatus();
    }
}