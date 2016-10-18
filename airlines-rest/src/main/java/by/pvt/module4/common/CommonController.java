package by.pvt.module4.common;

import by.pvt.module4.model.User;
import by.pvt.module4.services.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public abstract class CommonController<T extends Fact> {
    protected Logger log = LogManager.getLogger(CommonController.class);

    private static final DateFormat DF = new SimpleDateFormat("dd.MM.yyyy");
    private static final Integer DEF_PAGE_SIZE = 3;
    private static final String PARAM_PAGE_SIZE = "page_size";
    private static final String PARAM_PAGE_NUM = "page_num";

    protected List<T> findPage(Map<String, String> paramMap, CommonService<T> service) {
        Integer page = getParamIntDef(paramMap, PARAM_PAGE_NUM, 1);
        Integer size = getParamIntDef(paramMap, PARAM_PAGE_SIZE, DEF_PAGE_SIZE);
        return service.findPage(new PageRequest(page, size)).getContent();
    }

    protected User getSecurityUser(UserService userService) {
        String userLogin = getPrincipal();
        if (userLogin != null)
            try {
                List<User> users = userService.findByLogin(userLogin);
                if (!users.isEmpty())
                    return users.get(0);
            } catch (Exception e) {
            }
        return null;
    }

    private String getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) return null;
        String userName;
        Object principal = authentication.getPrincipal();
        if (principal == null) return null;
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    protected Integer getParamIntDef(Map<String, String> paramMap, String key, Integer def) {
        Integer value = def;
        if (paramMap.containsKey(key) && paramMap.get(key) != null)
            try {
                value = Integer.parseInt(paramMap.get(key).trim());
            } catch (NumberFormatException e) {
                log.error(e);
            }
        return value;
    }
}
