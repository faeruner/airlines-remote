package by.pvt.module4.rest.controller;

import by.pvt.module4.model.User;
import by.pvt.module4.model.Users;
import by.pvt.module4.rest.common.CommonController;
import by.pvt.module4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController extends CommonController<User, Users> {

    private static final String PARAM_LOGIN = "login";

    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public User data(@RequestParam(PARAM_LOGIN) String login) {
        List<User> users = ((UserService) commonService).findByLogin(login);
        return (users.isEmpty() ? null : users.get(0));
    }

}
