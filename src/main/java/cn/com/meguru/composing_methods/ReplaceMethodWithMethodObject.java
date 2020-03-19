package cn.com.meguru.composing_methods;

/**
 * 以函数对象取代函数
 * @author jiaoziang
 * @date 2020/3/19
 */
public class ReplaceMethodWithMethodObject {
}

//----------------------------------------------------------------------------------------------
/**
 * before
 * @author jiaoziang
 * @date 2020/3/19
 */
class Account {

    /**
     * before
     * @param inputVal
     * @param quantity
     * @param yearToDate
     * @return
     */
    int gamma(int inputVal, int quantity, int yearToDate) {
        int importantVal1 = (inputVal * quantity) + delta();
        int importantVal2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantVal1) > 100)
            importantVal2 -= 20;
        int importantVal3 = importantVal2 * 7;
        return importantVal3 - 2 * importantVal1;
    }

    //----------------------------------------------------------------------------------------------
    int gammaNE(int inputVal, int quantity, int yearToDate) {
        int importantVal2 = getImportantVal2(inputVal, quantity, yearToDate);
        int importantVal3 = importantVal2 * 7;
        return importantVal3 - 2 * getImportantVal1(inputVal, quantity);
    }

    private int getImportantVal2(int inputVal, int quantity, int yearToDate) {
        return getImportantVal2Condition(inputVal, quantity, yearToDate) ?
            getImportantVal2_1(inputVal, yearToDate) - 20 :
            getImportantVal2_1(inputVal, yearToDate);
    }

    private boolean getImportantVal2Condition(int inputVal, int quantity, int yearToDate) {
        return (yearToDate - getImportantVal1(inputVal, quantity)) > 100;
    }

    private int getImportantVal2_1(int inputVal, int yearToDate) {
        return (inputVal * yearToDate) + 100;
    }

    private int getImportantVal1(int inputVal, int quantity) {
        return (inputVal * quantity) + delta();
    }

    /**
     * after
     * @param inputVal
     * @param quantity
     * @param yearToDate
     * @return
     */
    int gammaN(int inputVal, int quantity, int yearToDate) {
        return new Gamma(this, inputVal, quantity, yearToDate).compute();
    }

    int delta() {
        return 0;
    }
}

//----------------------------------------------------------------------------------------------
/**
 * after
 * @author jiaoziang
 * @date 2020/3/19
 */
class Gamma {

    private final Account account;
    private int inputVal;
    private int quantity;
    private int yearToDate;

    public Gamma(Account account, int inputVal, int quantity, int yearToDate) {
        this.account = account;
        this.inputVal = inputVal;
        this.quantity = quantity;
        this.yearToDate = yearToDate;
    }

    int compute() {
        int importantVal1 = (inputVal * quantity) + account.delta();
        int importantVal2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantVal1) > 100)
            importantVal2 -= 20;
        int importantVal3 = importantVal2 * 7;
        return importantVal3 - 2 * importantVal1;
    }

    //----------------------------------------------------------------------------------------------
    int computeN() {
        return getImportantVal3() - 2 * getImportantVal1();
    }

    private int getImportantVal3() {
        return getImportantVal2() * 7;
    }

    private int getImportantVal2() {
        return getImportantVal2Condition() ? getImportantVal2_1() - 20 : getImportantVal2_1();
    }

    private boolean getImportantVal2Condition() {
        return (yearToDate - getImportantVal1()) > 100;
    }

    private int getImportantVal2_1() {
        return (inputVal * yearToDate) + 100;
    }

    private int getImportantVal1() {
        return (inputVal * quantity) + account.delta();
    }

}


