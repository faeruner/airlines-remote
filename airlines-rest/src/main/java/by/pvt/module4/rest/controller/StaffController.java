package by.pvt.module4.rest.controller;

import by.pvt.module4.model.Staff;
import by.pvt.module4.model.StaffList;
import by.pvt.module4.rest.common.CommonController;
import by.pvt.module4.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/staff")
public class StaffController extends CommonController<Staff, StaffList> {

    @Autowired
    public StaffController(StaffService service) {
        super(service);
    }

}

