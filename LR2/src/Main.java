import javax.smartcardio.Card;

public class Main {
    public static void main(String[] args) {
        var client = new Client("Petr Petrov", "KV0000000", "80441111111", "Petrov1234@gmail.com");
        System.out.println("New client Petr Petrov");
        var bankAccount1 = new BankAccount(client, "BYN", 580);
        System.out.println("Creat bank account for Petrov");
        bankAccount1.CreatNewCard();
        System.out.println("Creat new card");
        var card = bankAccount1.getCard();
        System.out.println("Your new card number: " + card.getCardNumber() + " Expiration date: " + card.getExpirationDate() + " CVV: " + card.getCvv() +" Pin: " + card.getPinCode());
        var bankAccount2 = new BankAccount("Ivan Ivanov", "KN111111111", "80291111111", "Ivanov1234@gmail.com", "BYN", 790);
        System.out.println("Creat bank account for Ivanov");
        bankAccount2.CreatNewCard();
        System.out.println("Creat new card");
        var card2 = bankAccount2.getCard();
        System.out.println("Your new card number: " + card2.getCardNumber() + " Expiration date: " + card2.getExpirationDate() + " CVV: " + card2.getCvv() +" Pin: " + card2.getPinCode());
        var credit = new Credit(500, 1, 12);
        System.out.println("Deactivate credit");
        credit.Deactivate();
        var deposit = new Deposit(500, 1, 12);
        System.out.println("Deactivate deposit");
        deposit.Deactivate();
        var bank = new BankBranch("BelarusBank", "Dzerzinskogo 69", "Minsk");
        System.out.println("Creat bank");
        bank.AddATM("Dzerzinskogo 83");
        bank.AddEmployee("analyst", "Maria Ivanova", "finans", 800);
    }
}