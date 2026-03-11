import java.util.*;

class BankCard {
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private String pinCode;
    private boolean isBlocked;

    public BankCard() {
        Random random = new Random();
        this.cardNumber = generateCardNumber();
        this.expirationDate = random.nextInt(1, 13) + "/" + random.nextInt(27, 36);
        this.cvv = String.valueOf(random.nextInt(900) + 100);
        this.pinCode = String.format("%04d", random.nextInt(10000));
        this.isBlocked = false;
    }

    private String generateCardNumber() {
        String card = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            card += String.format("%04d", random.nextInt(10000)) + ' ';
        }
        return card;
    }

    public void blockCard() {
        this.isBlocked = true;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}