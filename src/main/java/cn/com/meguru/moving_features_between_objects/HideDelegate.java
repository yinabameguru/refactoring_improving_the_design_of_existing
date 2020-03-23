package cn.com.meguru.moving_features_between_objects;

/**
 * 隐藏委托
 * @author jiaoziang
 * @date 2020/3/23
 */
public class HideDelegate {

    //----------------------------------------------------------------------------------------------

    /**
     * before
     * @param person
     * @return
     */
//    PersonHD getManager(PersonHD person) {
//        return person.getDepartment().getManager();
//    }

    /**
     * after
     * @param person
     * @return
     */
    PersonHD getManager(PersonHD person) {
        return person.getManager();
    }

}

/**
 * before
 */
/*
class PersonHD {

    DepartmentHD department;

    public DepartmentHD getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentHD department) {
        this.department = department;
    }

}

class DepartmentHD {

    private String chargeCode;

    private PersonHD manager;

    public PersonHD getManager() {
        return manager;
    }

    public void setManager(PersonHD manager) {
        this.manager = manager;
    }
}
*/

class PersonHD {

    DepartmentHD department;

    public PersonHD getManager() {
        return department.getManager();
    }

}

class DepartmentHD {

    private String chargeCode;

    private PersonHD manager;

    public PersonHD getManager() {
        return manager;
    }

    public void setManager(PersonHD manager) {
        this.manager = manager;
    }
}
