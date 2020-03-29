package cn.com.meguru.organizing_data;

/**
 * 自封装字段
 * @author jiaoziang
 * @date 2020/3/29
 */
public class SelfEncapsulateField {
}

/**
 * before
 */
/*
class IntRange {
    private int low, high;

    boolean includes(int arg) {
        return arg >= low && arg <= high;
    }

    void grow(int factor) {
        high = high * factor;
    }

    public IntRange(int low, int high) {
        this.low = low;
        this.high = high;
    }

}
*/

/**
 * after
 */
class IntRange {
    private int low, high;

    boolean includes(int arg) {
        return arg >= getLow() && arg <= getHigh();
    }

    void grow(int factor) {
        setHigh(getHigh() * factor);
    }

    public IntRange(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}
