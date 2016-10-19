package by.pvt.module4.model;

import java.io.Serializable;
import java.util.List;

public class StaffList implements Serializable {
    List<Staff> staffList;

    public StaffList() {
    }

    public StaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
