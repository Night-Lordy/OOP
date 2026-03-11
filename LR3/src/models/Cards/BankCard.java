package models.Cards;

import java.util.Random;

public abstract class BankCard {
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private String pinCode;
    private int discount;

    public BankCard(int discount) {
        Random random = new Random();
        this.cardNumber = generateCardNumber();
        this.expirationDate = random.nextInt(1, 13) + "/" + random.nextInt(27, 36);
        this.cvv = String.valueOf(random.nextInt(900) + 100);
        this.pinCode = String.format("%04d", random.nextInt(10000));
        this.discount = discount;
    }

    private String generateCardNumber() {
        String card = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            card += String.format("%04d", random.nextInt(10000)) + ' ';
        }
        return card;
    }

    public double CalcPrice(double startPrice){
        double finishPrise;
        finishPrise = startPrice * ((100 - discount) / 100);
        return finishPrise;
    }
}
