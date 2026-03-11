import java.util.*;

public class BankAccount {
    private Client owner;
    private BankCard card;
    private String currency;
    private double balance;
    private boolean isFrozen;

    public BankAccount(Client owner, String currency, double balance) {
        this.owner = owner;
        this.currency = currency.toUpperCase();
        this.balance = balance;
        this.isFrozen = false;
    }

    public BankAccount(String fullName, String passportData, String phone, String email, String currency, double balance){
        this.owner = new Client(fullName, passportData, phone, email);
        this.currency = currency;
        this.balance = balance;
        this.isFrozen = false;
    }

     public double AddMoney(double sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Sum must be positive");
        }
        this.balance += sum;
        return this.balance;
    }

    public double GetMoney(double sum) {
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

    public void CreatNewCard(){
        this.card = new BankCard();
    }

    public void freezeAccount() {
        this.isFrozen = true;
    }

    public void unfreezeAccount() {
        this.isFrozen = false;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isFrozen(){
        return isFrozen;
    }

    public String GetCurrency(){
        return currency;
    }

    public Client GetOwner(){
        return owner;
    }

    public BankCard getCard() {
        return card;
    }
}
