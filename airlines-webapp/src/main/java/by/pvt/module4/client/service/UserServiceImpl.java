package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.User;
import by.pvt.module4.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service("userService")
public class UserServiceImpl extends CommonServiceImpl<User, Users> implements UserService {

    private static final String PROP_REST_GET_DATA = "rest.suffix.getData";

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate, Environment env) {
        super(restTemplate, env, "user");
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User getUserByLogin(String login) {
        return restTemplate.getForObject(getPath(PROP_REST_GET_DATA + "login={login}"), User.class, login);
    }
}
