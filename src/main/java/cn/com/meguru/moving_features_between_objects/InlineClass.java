package cn.com.meguru.moving_features_between_objects;

/**
 * 内联类
 * @author jiaoziang
 * @date 2020/3/23
 */
public class InlineClass {
}

/**
 * before
 */
/*
class Person2 {

    private String name;

    private TelephoneNumber2 telephoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TelephoneNumber2 getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(TelephoneNumber2 telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}

class TelephoneNumber2 {

    private String officeAreaCode;

    private String officeNumber;

    public String getOfficeAreaCode() {
        return officeAreaCode;
    }

    public void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

}
*/

/**
 * after
 */
class Person2 {

    private String name;

    private String officeAreaCode;

    private String officeNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeAreaCode() {
        return officeAreaCode;
    }

    public void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

}

