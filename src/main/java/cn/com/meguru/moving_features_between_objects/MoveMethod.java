package cn.com.meguru.moving_features_between_objects;

/**
 * 转移方法
 * @author jiaoziang
 * @date 2020/3/22
 */
public class MoveMethod {
}

/**
 * before
 */
/*
class Account {

    private AccountType type;

    private int daysOverdrawn;

    double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (daysOverdrawn > 7)
                result += (daysOverdrawn - 7) * 0.85;
            return result;
        } else return daysOverdrawn * 1.75;
    }

    double bankCharge() {
        double result = 4.5;
        if (daysOverdrawn > 0) result += overdraftCharge();
        return result;
    }

}

class AccountType {

    public boolean isPremium() {
        return false;
    }

}
*/

/**
 * after
 */
class Account {

    private AccountType type;

    private int daysOverdrawn;

    double bankCharge() {
        double result = 4.5;
        if (daysOverdrawn > 0) result += type.overdraftCharge(daysOverdrawn);
        return result;
    }

}

class AccountType {

    public boolean isPremium() {
        return false;
    }

    double overdraftCharge(int daysOverdrawn) {
        if (isPremium()) {
            double result = 10;
            if (daysOverdrawn > 7)
                result += (daysOverdrawn - 7) * 0.85;
            return result;
        } else return daysOverdrawn * 1.75;
    }

}