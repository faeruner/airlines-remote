package by.pvt.module4.services;

import by.pvt.module4.model.User;
import by.pvt.module4.repository.UserRepository;
import by.pvt.module4.common.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends CommonServiceImpl<User> implements UserService {

    @Override
    public List<User> findByLogin(String login) {
        return ((UserRepository) commonRepository).findByLogin(login);
    }
}
