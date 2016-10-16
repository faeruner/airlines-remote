package by.pvt.module4.services;

import by.pvt.module4.common.CommonServiceImpl;
import by.pvt.module4.model.Staff;

import java.util.List;

public class StaffServiceImpl extends CommonServiceImpl<Staff> implements StaffService {

    @Override
    public Staff findById(Integer id, Boolean full) {
        Staff staff = super.findById(id, full);
        if (full) {
            staff.getCrews().iterator();
            staff.getMember();
        }
        return staff;
    }

    @Override
    public List<Staff> findPage(Integer page, Integer size, Boolean full) {
        List<Staff> staffs = super.findPage(page, size, full);
        if (full) {
            staffs.forEach(item -> {
                item.getCrews().iterator();
                item.getMember();
            });
        }
        return staffs;
    }

    @Override
    public List<Staff> findAll(Boolean full) {
        List<Staff> staffs = super.findAll(full);
        if (full) staffs.forEach(item -> {
            item.getCrews().iterator();
            item.getMember();
        });
        return staffs;
    }
}
