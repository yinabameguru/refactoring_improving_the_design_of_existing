package cn.com.meguru.composing_methods;

/**
 * 以查询取代临时变量
 *
 * @author jiaoziang
 * @date 2020/3/15
 */
public class ReplaceTempWithQuery {

    private int quantity, itemPrice;

    //----------------------------------------------------------------------------------------------
    /**
     * before
     * @return
     */
    public double getPrice() {
        int basePrivate = quantity * itemPrice;
        double discountFactor;
        if (basePrivate > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrivate * discountFactor;
    }

    //----------------------------------------------------------------------------------------------
    /**
     * after
     * @return
     */
    public double getPriceN() {
        return getBasePrice() * getDiscountFactor();
    }

    private int getBasePrice() {
        return quantity * itemPrice;
    }

    private double getDiscountFactor() {
        if (getBasePrice() > 1000) return 0.95;
        return 0.98;
    }

}
