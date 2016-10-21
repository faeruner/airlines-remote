package by.pvt.module3.controller;

import by.pvt.module3.controller.common.CommonController;
import by.pvt.module3.entity.User;
import by.pvt.module3.filter.UserType;
import by.pvt.module3.resource.ConfigurationManager;
import by.pvt.module3.resource.MessageManager;
import by.pvt.module3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController extends CommonController<User> {

    private final AirlineController airlineController;
    private final CrewController crewController;

    @Autowired
    public LoginController(CrewController crewController, AirlineController airlineController, UserService userService) {
        super("path.page.login", "path.page.login", userService, userService);
        Assert.notNull(crewController, "crewService must not be Null!");
        this.crewController = crewController;
        Assert.notNull(airlineController, "airlineService must not be Null!");
        this.airlineController = airlineController;
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpServletRequest httpRequest, HttpServletResponse httpResponse, HttpSession httpSession) {
        String page = ConfigurationManager.getProperty("path.page.index");
//        httpSession.invalidate();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(httpRequest, httpResponse, authentication);
        }
        return "redirect:/" + page;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    private String login(@RequestParam Map<String, String> paramMap, Model model, HttpSession httpSession) {
        String page = ConfigurationManager.getProperty("path.page.login");
        User user = getSecurityUser(model);
        if (user != null) {
            model.addAttribute("user", user);

            if (UserType.ADMINISTRATOR.getId().equals(user.getRole().getId())) {
                httpSession.setAttribute("userType", UserType.ADMINISTRATOR);
                page = airlineController.perform(paramMap, model);
            } else if (UserType.DISPATCHER.getId().equals(user.getRole().getId())) {
                httpSession.setAttribute("userType", UserType.DISPATCHER);
                page = crewController.perform(paramMap, model);
            }
        }
        return page;
    }

    @RequestMapping(value = "/access_denied", method = {RequestMethod.POST, RequestMethod.GET})
    private String accessDenied(@RequestParam Map<String, String> paramMap, Model model, HttpSession httpSession) {
        User user = getSecurityUser(model);
        if (user != null) {
            model.addAttribute("user", user);
        }
        model.addAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
        return ConfigurationManager.getProperty("path.page.login");
    }
}
