package by.pvt.module4.rest.controller;

import by.pvt.module4.model.UserRole;
import by.pvt.module4.model.UserRoles;
import by.pvt.module4.rest.common.CommonController;
import by.pvt.module4.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/userrole")
public class UserRoleController extends CommonController<UserRole, UserRoles> {

    @Autowired
    public UserRoleController(UserRoleService service) {
        super(service);
    }
}
