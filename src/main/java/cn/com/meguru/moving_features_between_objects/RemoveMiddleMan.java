package cn.com.meguru.moving_features_between_objects;

/**
 * @author jiaoziang
 * @date 2020/3/23
 */
public class RemoveMiddleMan {

    /**
     * before
     * @param person
     * @return
     */
//    PersonRMM getManager(PersonRMM person) {
//        return person.getManager();
//    }

    /**
     * after
     * @param person
     * @return
     */
    PersonRMM getManager(PersonRMM person) {
        return person.getDepartment().getManager();
    }

}

/**
 * before
 */
/*
class PersonRMM {

    DepartmentRMM department;

    public PersonRMM getManager() {
        return department.getManager();
    }

}

class DepartmentRMM {

    private String chargeCode;

    private PersonRMM manager;

    public PersonRMM getManager() {
        return manager;
    }

    public void setManager(PersonRMM manager) {
        this.manager = manager;
    }
}
*/

/**
 * after
 */
class PersonRMM {

    DepartmentRMM department;

    public DepartmentRMM getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentRMM department) {
        this.department = department;
    }

}

class DepartmentRMM {

    private String chargeCode;

    private PersonRMM manager;

    public PersonRMM getManager() {
        return manager;
    }

    public void setManager(PersonRMM manager) {
        this.manager = manager;
    }
}


