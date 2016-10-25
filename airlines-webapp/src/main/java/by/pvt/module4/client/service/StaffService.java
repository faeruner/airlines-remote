package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Staff;
import by.pvt.module4.model.StaffList;
import org.springframework.stereotype.Service;

@Service
public class StaffService extends CommonServiceImpl<Staff, StaffList> {
    public StaffService() {
        super("staff");
    }
}
