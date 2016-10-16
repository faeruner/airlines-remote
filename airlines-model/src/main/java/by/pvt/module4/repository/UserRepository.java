package by.pvt.module4.repository;

import by.pvt.module4.common.CommonRepository;
import by.pvt.module4.model.User;

import java.util.List;

public interface UserRepository extends CommonRepository<User>{
    List<User> findByLogin(String login);
}
