package by.pvt.module3.service;

import by.pvt.module3.dao.common.CommonDao;
import by.pvt.module3.entity.UserRole;
import by.pvt.module3.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService extends BaseService<UserRole> {
    @Autowired
    public UserRoleService(CommonDao<UserRole> dao) {
        super(dao);
    }
}
