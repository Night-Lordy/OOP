public class Teller extends BankEmployee{
    private int accessLevel;

    Teller(String fullName, String department, double salary){
        super(fullName, department, salary);
        this.accessLevel = 1;
    }
}
