package cn.com.meguru.moving_features_between_objects;

/**
 * 转移字段
 * @author jiaoziang
 * @date 2020/3/22
 */
public class MoveField {
}

/**
 * before
 */
/*
class Account2 {

    private AccountType2 accountType;

    private double interestRate;

    double interestForAmountDays(double amount, int days) {
        return interestRate * amount * days / 365;
    }

}

class AccountType2 {

}
*/

/**
 * before
 */
class Account2 {

    private AccountType2 accountType;

    double interestForAmountDays(double amount, int days) {
        return accountType.getInterestRate() * amount * days / 365;
    }

}

class AccountType2 {

    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}