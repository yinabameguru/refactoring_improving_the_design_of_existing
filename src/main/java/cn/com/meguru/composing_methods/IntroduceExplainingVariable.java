package cn.com.meguru.composing_methods;

/**
 * 引入解释性变量
 * @author jiaoziang
 * @date 2020/3/15
 */
public class IntroduceExplainingVariable {

    private int quantity, itemPrice;

    //----------------------------------------------------------------------------------------------
    /**
     * before
     * @return
     */
    public double price() {
        //base price - quantity discount + shipping
        return quantity * itemPrice -
            Math.max(quantity, 500) * itemPrice * 0.05 +
            Math.min(quantity * itemPrice * 0.1, 100);
    }

    //----------------------------------------------------------------------------------------------
    /**
     * after
     * @return
     */
    public double priceN() {
        final int basePrice = quantity * itemPrice;
        final double quantityDiscount = Math.max(quantity, 500) * itemPrice * 0.05;
        final double shipping = Math.min(basePrice * 0.1, 100);
        return basePrice - quantityDiscount + shipping;
    }

    //----------------------------------------------------------------------------------------------
    /**
     * use explaining method
     * @return
     */
    public double priceEM() {
        return getBasePrice() - getQuantityDiscount() + getShipping();
    }

    private double getShipping() {
        return Math.min(getBasePrice() * 0.1, 100);
    }

    private double getQuantityDiscount() {
        return Math.max(quantity, 500) * itemPrice * 0.05;
    }

    private int getBasePrice() {
        return quantity * itemPrice;
    }

}
