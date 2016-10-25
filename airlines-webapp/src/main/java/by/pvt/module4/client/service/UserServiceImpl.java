package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.User;
import by.pvt.module4.model.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl extends CommonServiceImpl<User, Users> implements UserService {

    private static final String PROP_REST_GET_DATA = "rest.suffix.getData";

    public UserServiceImpl() {
        super("user");
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User getUserByLogin(String login) {
        return restTemplate.getForObject(getPath(PROP_REST_GET_DATA) + "login={login}", User.class, login);
    }
}
