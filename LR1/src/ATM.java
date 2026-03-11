import java.util.*;

class ATM {
    private String atmId;
    private String location;
    private String branchCode;
    private double cashBalance;
    private boolean isOperational;
    private Set<String> acceptedCurrencies;

    public ATM(String location, String branchCode) {
        this.atmId = UUID.randomUUID().toString().substring(0, 8);
        this.location = location;
        this.branchCode = branchCode;
        this.cashBalance = 0.0;
        this.isOperational = true;
        this.acceptedCurrencies = new HashSet<>(Arrays.asList("RUB", "USD", "EUR"));
    }

    public void loadCash(double sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Sum must be positive");
        }
        this.cashBalance += sum;
    }

    public boolean withdrawCash(double sum) {
        if (!isOperational) {
            throw new IllegalStateException("ATM doesn't work");
        }
        if (cashBalance < sum) {
            throw new IllegalArgumentException("Not enough funds");
        }

        this.cashBalance -= sum;
        return true;
    }

    public void setMaintenance() {
        this.isOperational = false;
    }

    public void endMaintenance() {
        this.isOperational = true;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public String getAtmId() {
        return atmId;
    }

    public double getCashBalance() {
        return cashBalance;
    }
}