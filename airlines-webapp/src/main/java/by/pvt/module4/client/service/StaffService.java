package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Staff;
import by.pvt.module4.model.StaffList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StaffService extends CommonServiceImpl<Staff, StaffList> {
    @Autowired
    public StaffService(RestTemplate restTemplate, Environment env) {
        super(restTemplate, env, "staff");
    }
}
