import java.util.*;

class BankBranch {
    private String branchName;
    private String address;
    private String city;
    private String openingTime;
    private String closingTime;
    private List<BankEmployee> employees;
    private List<ATM> atms;

    public BankBranch(String branchName, String address, String city) {
        this.branchName = branchName;
        this.address = address;
        this.city = city;
        this.openingTime = "09:00";
        this.closingTime = "18:00";
        this.employees = new ArrayList<>();
        this.atms = new ArrayList<>();
    }

    public void AddATM(String location){
        boolean add = this.atms.add(new ATM(location));
        if(add){
            System.out.println("ATM is add");
        } else System.out.println("Error");
    }

    public void AddEmployee(String position, String fullName, String department, double salary){
        boolean add;
        switch (position){
            case "analyst" :
                add = this.employees.add(new Analyst(fullName, department, salary));
                break;
            case "supervisor":
                add = this.employees.add(new Supervisor(fullName, department, salary));
                break;
            case "teller" :
                add = this.employees.add(new Teller(fullName, department, salary));
                break;
            default:
                add = false;
                break;
        }
        if(add){
            System.out.println("Employee is add");
        } else System.out.println("Error");
    }

    public boolean isOpen(String checkTime) {
        return checkTime.compareTo(openingTime) >= 0 &&
                checkTime.compareTo(closingTime) <= 0;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getBranchName() {
        return branchName;
    }


    public List<ATM> getAtms() {
        return atms;
    }

    public List<BankEmployee> getEmployees() {
        return employees;
    }
}