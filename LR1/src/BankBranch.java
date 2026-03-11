import java.util.*;

class BankBranch {
    private String branchCode;
    private String branchName;
    private String address;
    private String city;
    private String openingTime;
    private String closingTime;
    private List<String> employees;
    private List<String> atms;

    public BankBranch(String branchName, String address, String city) {
        this.branchCode = String.valueOf(new Random().nextInt(90000) + 10000);
        this.branchName = branchName;
        this.address = address;
        this.city = city;
        this.openingTime = "09:00";
        this.closingTime = "18:00";
        this.employees = new ArrayList<>();
        this.atms = new ArrayList<>();
    }

    public void addEmployee(String employeeId) {
        employees.add(employeeId);
    }

    public void removeEmployee(String employeeId) {
        employees.remove(employeeId);
    }

    public void addAtm(String atmId) {
        atms.add(atmId);
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

    public String getBranchCode(){
        return branchCode;
    }

    public List<String> getAtms() {
        return atms;
    }

    public List<String> getEmployees() {
        return employees;
    }
}