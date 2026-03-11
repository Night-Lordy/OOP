public class Analyst extends BankEmployee {
    private int accessLevel;

    Analyst(String fullName, String department, double salary){
        super(fullName, department, salary);
        this.accessLevel = 3;
    }
}
