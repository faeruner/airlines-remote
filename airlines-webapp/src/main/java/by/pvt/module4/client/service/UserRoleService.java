package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.UserRole;
import by.pvt.module4.model.UserRoles;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService extends CommonServiceImpl<UserRole, UserRoles> {
    public UserRoleService() {
        super("userrole");
    }
}
