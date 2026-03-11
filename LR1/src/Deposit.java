import java.util.UUID;

class Deposit {
    private String depositId;
    private String clientId;
    private String accountNumber;
    private double sum;
    private double present;
    private int termDays;
    private boolean isActive;

    public Deposit(String clientId, String accountNumber, double sum, double present, int termDays) {
        this.depositId = UUID.randomUUID().toString().substring(0, 8);
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.sum = sum;
        this.present = present;
        this.termDays = termDays;
        this.isActive = true;
    }

    public double calculatePres() {
        return sum * present / 100 * (termDays / 365.0);
    }

    public void applyCapitalization() {
        if (isActive) {
            double pres = calculatePres();
            this.sum += pres;
        }
    }

    public double closeDeposit() {
        this.isActive = false;
        return sum + calculatePres();
    }

    public boolean isActive() {
        return isActive;
    }

    public String getDepositId() {
        return depositId;
    }
}