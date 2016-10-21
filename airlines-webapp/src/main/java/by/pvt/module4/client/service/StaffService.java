package by.pvt.module3.service;

import by.pvt.module3.dao.common.CommonDao;
import by.pvt.module3.entity.Staff;
import by.pvt.module3.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService extends BaseService<Staff> {
    @Autowired
    public StaffService(CommonDao<Staff> dao) {
        super(dao);
    }
}
