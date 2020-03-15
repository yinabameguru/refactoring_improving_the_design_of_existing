package cn.com.meguru;

/**
 * 以查询取代临时变量
 *
 * @author jiaoziang
 * @date 2020/3/15
 */
public class ReplaceTempWithQuery {

    private int quantity, itemPrivate;

    //----------------------------------------------------------------------------------------------
    //before
    public double getPrivate() {
        int basePrivate = quantity * itemPrivate;
        double discountFactor;
        if (basePrivate > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrivate * discountFactor;
    }

    //----------------------------------------------------------------------------------------------
    //after
    public double getPrivateN() {
        return getBasePrivate() * getDiscountFactor();
    }

    private int getBasePrivate() {
        return quantity * itemPrivate;
    }

    private double getDiscountFactor() {
        if (getBasePrivate() > 1000) return 0.95;
        return 0.98;
    }

}
