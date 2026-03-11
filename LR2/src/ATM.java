import java.util.*;

class ATM {
    private String location;
    private double cashBalance;
    private boolean isOperational;
    private Set<String> acceptedCurrencies;

    public ATM(String location) {
        this.location = location;
        this.cashBalance = 1000.0;
        this.isOperational = true;
        this.acceptedCurrencies = new HashSet<>(Arrays.asList("RUB", "USD", "EUR"));
    }

    public void LoadCash(double sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Sum must be positive");
        }
        this.cashBalance += sum;
    }

    public boolean GetCash(double sum) {
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

    public double getCashBalance() {
        return cashBalance;
    }

    public String GetLocation() {
        return location;
    }
}