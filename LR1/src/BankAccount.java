import java.util.UUID;

public class BankAccount {
    private String accountNumber;
    private String clientId;
    private String currency;
    private double balance;
    private boolean isFrozen;

    public BankAccount(String clientId, String currency, double initialBalance) {
        this.accountNumber = generateId(12);
        this.clientId = clientId;
        this.currency = currency.toUpperCase();
        this.balance = initialBalance;
        this.isFrozen = false;
    }

    private String generateId(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }

    public double deposit(double sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Sum must be positive");
        }
        this.balance += sum;
        return this.balance;
    }

    public double withdraw(double sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Sum must be positive");
        }
        if (isFrozen) {
            throw new IllegalStateException("Account is frozen");
        }
        if (balance < sum) {
            throw new IllegalArgumentException("Not enough funds");
        }
        this.balance -= sum;
        return this.balance;
    }

    public void freezeAccount() {
        this.isFrozen = true;
    }

    public void unfreezeAccount() {
        this.isFrozen = false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isFrozen(){
        return isFrozen;
    }
}
