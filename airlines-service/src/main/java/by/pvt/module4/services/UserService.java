package by.pvt.module4.services;

import by.pvt.module4.model.User;
import by.pvt.module4.common.CommonService;

import java.util.List;

public interface UserService extends CommonService<User> {
    List<User> findByLogin(String login);
}
