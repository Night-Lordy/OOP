import java.util.*;

abstract class BankProduct {
    private double sum;
    private double present;
    private int termMonths;
    private boolean isActive;

    BankProduct(double sum, double present, int termMonths){
        this.sum = sum;
        this.present = present;
        this.termMonths = termMonths;
        this.isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getSum() {
        return sum;
    }

    public double getPresent() {
        return present;
    }

    public int GetTermMonths() {
        return termMonths;
    }

    public void Deactivate(){
        this.isActive = false;
    }
}
