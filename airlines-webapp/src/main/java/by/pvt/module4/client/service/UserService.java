package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonService;
import by.pvt.module4.model.User;

public interface UserService extends CommonService<User> {
    User getUserByLogin(String login);
}
