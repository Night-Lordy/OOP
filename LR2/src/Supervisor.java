public class Supervisor extends BankEmployee {
    private int accessLevel;

    public Supervisor(String fullName, String department, double salary){
        super(fullName, department, salary);
        this.accessLevel = 5;
    }
}
