package by.pvt.module3.controller;

import by.pvt.module3.controller.common.CommonController;
import by.pvt.module3.entity.User;
import by.pvt.module3.entity.UserRole;
import by.pvt.module3.service.UserService;
import by.pvt.module3.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping(value = "/controller/user", method = {RequestMethod.GET, RequestMethod.POST})
public class UserController extends CommonController<User> {
    private static final String LIST_USER_ROLE = "user_roles";

    private final CommonService<UserRole> userRoleService;

    @Autowired
    public UserController(UserService userService, CommonService<User> commonService, CommonService<UserRole> userRoleService) {
        super("path.page.edit_user", "path.page.users", userService, commonService);
        Assert.notNull(userRoleService, "userRoleService must not be Null!");
        this.userRoleService = userRoleService;
    }

    @RequestMapping
    public String perform(@RequestParam Map<String, String> paramMap, Model model) {
        model.addAttribute(LIST_USER_ROLE, userRoleService.getAll());
        model.addAttribute(CommonController.ENTITY, updateEntity(findById(paramMap, model), paramMap));
        return getPage(paramMap, model);
    }

    private User updateEntity(User user, Map<String, String> paramMap) {
        if (user == null)
            user = new User();
        if (paramMap.containsKey(User.NAME)) user.setName(paramMap.get(User.NAME).trim());
        if (paramMap.containsKey(User.SURNAME)) user.setSurname(paramMap.get(User.SURNAME).trim());
        if (paramMap.containsKey(User.LOGIN)) user.setLogin(paramMap.get(User.LOGIN).trim());
        if (paramMap.containsKey(User.PASSWORD)) user.setPassword(paramMap.get(User.PASSWORD).trim());
        if (paramMap.containsKey(User.USER_ROLE_ID))
            user.setRole(userRoleService.getById(getParamIntDef(paramMap, User.USER_ROLE_ID, 1)));
        return user;
    }
}
