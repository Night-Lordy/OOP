import java.util.UUID;

class BankEmployee {
    private String employeeId;
    private String fullName;
    private String position;
    private String department;
    private double salary;
    private boolean isActive;
    private int accessLevel;

    public BankEmployee(String fullName, String position, String department, double salary) {
        this.employeeId = UUID.randomUUID().toString().substring(0, 6);
        this.fullName = fullName;
        this.position = position.toLowerCase();
        this.department = department;
        this.salary = salary;
        this.isActive = true;
        this.accessLevel = determineAccessLevel(position);

    }

    private int determineAccessLevel(String position) {
        switch (position) {
            case "teller": return 1;
            case "manager": return 2;
            case "supervisor": return 3;
            case "analyst": return 2;
            default: return 0;
        }
    }

    public void changePosition(String newPosition) {
        this.position = newPosition;
    }

    public double giveBonus(double bonusSum) {
        this.salary += bonusSum;
        return this.salary;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }
}