package cn.com.meguru;

/**
 * 移除对参数的赋值
 * @author jiaoziang
 * @date 2020/3/18
 */
public class RemoveAssignmentsToParameters {

    //----------------------------------------------------------------------------------------------
    /**
     * before
     * @return
     */
    public int discount(int inputVal, int quantity, int yearToDate) {
        if (inputVal > 50) inputVal -= 2;
        if (quantity > 100) inputVal -= 1;
        if (yearToDate > 10000) inputVal -= 4;
        return inputVal;
    }

    //----------------------------------------------------------------------------------------------
    /**
     * after
     * @return
     */
    public int discountN(int inputVal, int quantity, int yearToDate) {
        int result = inputVal;
        if (inputVal > 50) result -= 2;
        if (quantity > 100) result -= 1;
        if (yearToDate > 10000) result -= 4;
        return result;
    }

}
