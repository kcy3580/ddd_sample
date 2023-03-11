package hello.core.discount.domain;

public class Discount {

    private int discountFixAmount = 1000;
    private double discountRate = 0;

    public void setDiscountRate(double discountDynamicAmount) {
        this.discountRate = discountDynamicAmount;
    }

    public void setDiscountFixAmount(int discountFixAmount) {
        this.discountFixAmount = discountFixAmount;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getDiscountFixAmount() {
        return discountFixAmount;
    }
}
