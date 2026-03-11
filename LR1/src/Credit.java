import java.util.UUID;

class Credit {
    private String creditId;
    private String clientId;
    private String accountNumber;
    private double sum;
    private double remainingSum;
    private double present;
    private int termMonths;
    private boolean isClosed;

    public Credit(String clientId, String accountNumber, double sum, double present, int termMonths) {
        this.creditId = UUID.randomUUID().toString().substring(0, 8);
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.sum = sum;
        this.remainingSum = sum;
        this.present = present;
        this.termMonths = termMonths;
        this.isClosed = false;
    }

    public double calculateMonthlyPayment() {
        double monthlyRate = present / 12 / 100;
        double payment = (sum * monthlyRate * Math.pow(1 + monthlyRate, termMonths)) / (Math.pow(1 + monthlyRate, termMonths) - 1);
        return Math.round(payment * 100.0) / 100.0;
    }

    public double makePayment(double sum) {
        if (isClosed) {
            throw new IllegalStateException("Credit is already close");
        }
        if (sum <= 0) {
            throw new IllegalArgumentException("Sum must be positive");
        }

        this.remainingSum = Math.max(0, this.remainingSum - sum);
        if (this.remainingSum == 0) {
            this.isClosed = true;
        }

        return this.remainingSum;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public String getCreditId() {
        return creditId;
    }

    public double getRemainingSum() {
        return remainingSum;
    }
}
