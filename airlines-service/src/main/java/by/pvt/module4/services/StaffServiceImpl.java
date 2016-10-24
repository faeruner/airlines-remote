package by.pvt.module4.services;

import by.pvt.module4.common.CommonServiceImpl;
import by.pvt.module4.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("staffService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class StaffServiceImpl extends CommonServiceImpl<Staff> implements StaffService {

    @Override
    public Staff findOne(Integer id, Boolean full) {
        Staff staff = super.findOne(id, full);
        if (full) {
//            staff.getCrews().iterator();
            staff.getMember();
        }
        return staff;
    }

    @Override
    public Page<Staff> findPage(Pageable page, Boolean full) {
        Page<Staff> staffs = super.findPage(page, full);
        if (full) {
            staffs.forEach(item -> {
//                item.getCrews().iterator();
                item.getMember();
            });
        }
        return staffs;
    }

    @Override
    public List<Staff> findAll(Boolean full) {
        List<Staff> staffs = super.findAll(full);
        if (full) staffs.forEach(item -> {
//            item.getCrews().iterator();
            item.getMember();
        });
        return staffs;
    }
}
