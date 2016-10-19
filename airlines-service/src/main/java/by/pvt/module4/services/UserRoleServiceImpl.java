package by.pvt.module4.services;

import by.pvt.module4.common.CommonServiceImpl;
import by.pvt.module4.model.UserRole;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleServiceImpl extends CommonServiceImpl<UserRole> implements UserRoleService {
}
