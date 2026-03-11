import java.util.*;

class BankCard {
    private String cardId;
    private String accountNumber;
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private String pinCode;
    private boolean isBlocked;

    public BankCard(String accountNumber, int expirationYear) {
        this.cardId = UUID.randomUUID().toString().substring(0, 8);
        this.accountNumber = accountNumber;
        this.cardNumber = generateCardNumber();
        this.expirationDate = "12/" + expirationYear;
        this.cvv = String.valueOf(new Random().nextInt(900) + 100);
        this.pinCode = "0000";
        this.isBlocked = false;
    }

    private String generateCardNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(String.format("%04d", random.nextInt(10000)));
        }
        return sb.toString();
    }

    public boolean changePin(String oldPin, String newPin) {
        if (this.pinCode.equals(oldPin) && newPin.length() == 4) {
            this.pinCode = newPin;
            return true;
        }
        return false;
    }

    public String getCardId() {
        return cardId;
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