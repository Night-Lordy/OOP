import java.util.*;

class BankingProduct {
    private String productId;
    private String clientId;
    private String productType;
    private double sum;
    private int termMonths;
    private boolean isActive;

    public BankingProduct(String clientId, String productType, double sum, int termMonths) {
        this.productId = UUID.randomUUID().toString().substring(0, 8);
        this.clientId = clientId;
        this.productType = productType.toLowerCase();
        this.sum = sum;
        this.termMonths = termMonths;
        this.isActive = true;
    }

    public double calculateAnnualFee() {
        double present;
        switch (productType) {
            case "insurance":
                present = sum * 0.05;
                break;
            case "investment":
                present = sum * 0.02;
                break;
            case "mortgage":
                present = sum * 0.01;
                break;
            case "pension":
                present = sum * 0.005;
                break;
            default:
                present = sum * 0.03;
        }
        return present;
    }

    public double terminateProduct() {
        this.isActive = false;
        double penalty = termMonths > 12 ? sum * 0.1 : sum * 0.2;
        return sum - penalty;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getSum() {
        return sum;
    }

    public String getProductId() {
        return productId;
    }
}
