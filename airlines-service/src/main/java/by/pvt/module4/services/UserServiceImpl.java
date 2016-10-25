package by.pvt.module4.services;

import by.pvt.module4.model.User;
import by.pvt.module4.repository.UserRepository;
import by.pvt.module4.rest.common.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl extends CommonServiceImpl<User> implements UserService {

    @Override
    public List<User> findByLogin(String login) {
        return ((UserRepository) commonRepository).findByLogin(login);
    }
}
