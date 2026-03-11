import java.util.UUID;

abstract class BankEmployee {
    private String fullName;
    private String department;
    private double salary;
    private boolean isActive;

    public BankEmployee(String fullName, String department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.isActive = true;
    }

    public double GiveBonus(double bonusSum) {
        this.salary += bonusSum;
        return this.salary;
    }

    public double GetSalary() {
        return salary;
    }

    public boolean IsActive() {
        return isActive;
    }

    public String GetDepartment() {
        return department;
    }

    public String GetFullName(){
        return fullName;
    }
}