
public class Main {
    public static void main(String[] args) {
        Client client = new Client("Ivan Ivanov", "KB1111111", "80441111111", "ivanov1234@gmail.com");
        client.ChangeEmail("ivanov5678@gmail.com");
        String clientId = client.getClientId();
        System.out.println("Created new client Ivan Ivanov. He's Id: " + clientId);

        BankAccount bankAccount = new BankAccount(clientId, "byn", 1378.5);
        String accountNumber = bankAccount.getAccountNumber();
        System.out.println("Create new bank account. It's number: " + accountNumber);
        bankAccount.deposit(25.5);
        double balance = bankAccount.getBalance();
        System.out.println("Balance after add sum: " + balance);

        BankCard bankCard = new BankCard(accountNumber, 28);
        String cvv = bankCard.getCvv();
        String oldPin = bankCard.getPinCode();
        String cardId = bankCard.getCardId();
        System.out.println("Create new card. Id: " + cardId + " Pin: " + oldPin + " CVV: " + cvv);
        bankCard.changePin(oldPin, "1234");
        System.out.println("Change card pin. Now it's '1234'");

        Credit credit = new Credit(clientId, accountNumber, 250, 10, 12);
        System.out.println("Take a credit");
        double monthlyPayment = credit.calculateMonthlyPayment();
        System.out.println("You must pay " + monthlyPayment + " in month");
        credit.makePayment(50);
        double sumNow = credit.getRemainingSum();
        System.out.println("You pay 50 and now remaining sum is " + sumNow);

        Deposit deposit = new Deposit(clientId, accountNumber, 250, 5, 200);
        System.out.println("You open deposit");
        double present = deposit.calculatePres();
        System.out.println("Your present on all time: " + present);
        deposit.applyCapitalization();
        double presentNow = deposit.calculatePres();
        System.out.println("Now your present is " + presentNow);

        BankAccount bankAccount2 = new BankAccount(clientId, "byn", 57.5);
        System.out.println("Create another bank account");
        String accountNumber2 = bankAccount2.getAccountNumber();
        Transaction transaction = new Transaction(accountNumber, accountNumber2, 20, "-");
        System.out.println("Make transaction between two account");
        String status = transaction.getStatus();
        System.out.println("Status of transaction: " + status);
        transaction.fail("Lost connection with bank");

        BankBranch bank = new BankBranch("BelarusBank", "pr. Dzerznskogo 69", "Minsk");
        System.out.println("Create bank");
        String branchCode = bank.getBranchCode();

        ATM atm = new ATM("pr. Dzerznskogo 83", branchCode);
        System.out.println("Create ATM");
        atm.loadCash(25.5);
        System.out.println("Put money to ATM");
        String atmId = atm.getAtmId();
        bank.addAtm(atmId);

        BankEmployee bankEmployee = new BankEmployee("Anastasia Popova", "analyst", "cash department", 890);
        System.out.println("New employee");
        String employeeId = bankEmployee.getEmployeeId();
        double newSalary = bankEmployee.giveBonus(100.7);
        System.out.println("Up employee salary to: " + newSalary);
        bank.addEmployee(employeeId);
        int accessLevel = bankEmployee.getAccessLevel();
        System.out.println("Access level of employee: " + accessLevel);

        BankingProduct bankingProduct = new BankingProduct(clientId, "pension", 40000, 12);
        System.out.println("Take one of bank product");
        double annualFee = bankingProduct.calculateAnnualFee();
        System.out.println("Annual fee of this product is: " + annualFee);
    }
}