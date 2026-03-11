class Credit extends BankProduct {
    private double remainingSum;

    public Credit(double sum, double present, int termMonths) {
        super(sum, present, termMonths);
        this.remainingSum = sum;
    }

    public double calculateMonthlyPayment() {
        int termMonths = super.GetTermMonths();
        double monthlyRate = super.getPresent() / 100 / 12;
        double payment = (super.getSum() * monthlyRate * Math.pow(1 + monthlyRate, termMonths)) / (Math.pow(1 + monthlyRate, termMonths) - 1);
        return Math.round(payment * 100.0) / 100.0;
    }

    public double makePayment(double sum) {
        if (super.isActive()) {
            throw new IllegalStateException("Credit is already close");
        }
        if (sum <= 0) {
            throw new IllegalArgumentException("Sum must be positive");
        }

        this.remainingSum = Math.max(0, this.remainingSum - sum);
        if (this.remainingSum == 0) {
            super.Deactivate();
            System.out.println("Credit close!");
        }
        return this.remainingSum;
    }

    public double getRemainingSum() {
        return remainingSum;
    }
}
