class Deposit extends BankProduct  {

    public Deposit(double sum, double present, int termDays) {
        super(sum, present, termDays);
    }

    public double calculatePres() {
        return super.getSum() * super.getPresent() / 100 * (super.GetTermMonths() / 365.0);
    }

    @Override
    public void Deactivate() {
        System.out.println("Close deposit");
        super.Deactivate();
    }
}