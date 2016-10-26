package by.pvt.module4.rest.common;

import by.pvt.module4.common.CommonEntityList;
import by.pvt.module4.common.Fact;
import by.pvt.module4.model.User;
import by.pvt.module4.services.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public abstract class CommonController<T extends Fact, L extends CommonEntityList<T>> {
    protected Logger log = LogManager.getLogger(CommonController.class);

    private final Class<L> listClazz;

    private static final DateFormat DF = new SimpleDateFormat("dd.MM.yyyy");
    private static final String PARAM_PAGE_SIZE = "size";
    private static final String PARAM_PAGE_NUM = "number";

    protected final CommonService<T> commonService;

    public CommonController(CommonService<T> commonService) {
        this.listClazz = (Class<L>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.commonService = commonService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public L list() {
        L list = null;
        try {
            list = listClazz.newInstance();
            list.setEntities(commonService.findAll());
        } catch (InstantiationException e) {
            log.error(e);
        } catch (IllegalAccessException e) {
            log.error(e);
        }
        return list;
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public L page(@RequestParam(PARAM_PAGE_NUM) Integer number, @RequestParam(PARAM_PAGE_SIZE) Integer size) {
        Page<T> page = commonService.findPage(new PageRequest(number - 1, size));

        L pageData = null;
        try {
            pageData = listClazz.newInstance();
            pageData.setEntities(page.getContent());
            pageData.setTotalElements(String.valueOf(page.getTotalElements()));
            pageData.setTotalPages(page.getTotalPages());
        } catch (InstantiationException e) {
            log.error(e);
        } catch (IllegalAccessException e) {
            log.error(e);
        }
        return pageData;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public T findById(@PathVariable Integer id) {
        return commonService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public T create(@RequestBody T entity) {
        log.info("Creating entity: " + entity);
        commonService.save(entity);
        log.info("Entity created successfully with info: " + entity);
        return entity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody T entity, @PathVariable Integer id) {
        log.info("Updating entity: " + entity);
        commonService.save(entity);
        log.info("Entity updated successfully with info: " + entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Integer id, HttpServletResponse response) {
        log.info("Deleting contact with id: " + id);
        T crew = commonService.findOne(id);
        try {
            commonService.delete(crew);
        } catch (Exception e) {
            log.error(e);
            try {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            } catch (IOException e1) {
                log.error(e1);
            }

        }
        log.info("Entity deleted successfully");
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
