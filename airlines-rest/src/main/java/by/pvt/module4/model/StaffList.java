package by.pvt.module4.model;

import by.pvt.module4.common.CommonEntityListImpl;

import java.util.List;

public class StaffList extends CommonEntityListImpl<Staff> {
    public StaffList() {
        super();
    }

    public StaffList(List<Staff> staffList) {
        super(staffList);
    }

    public List<Staff> getStaffList() {
        return getEntity();
    }

    public void setStaffList(List<Staff> staffList) {
        setEntity(staffList);
    }
}
