package by.pvt.module4.client.common;

import by.pvt.module4.client.service.UserService;
import by.pvt.module4.common.CommonEntityList;
import by.pvt.module4.common.Fact;
import by.pvt.module4.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class CommonController<T extends Fact> {
    private Logger log = LogManager.getLogger(CommonController.class);

    protected static final DateFormat DF = new SimpleDateFormat("dd.MM.yyyy");
    private static final Integer PAGE_SIZE = 3;

    private static final String COMMAND = "command";
    private static final String COMMAND_EDIT = "edit";
    protected static final String COMMAND_DEL = "del";
    protected static final String COMMAND_ADD = "add";
    private static final String COMMAND_UPD = "upd";
    private static final String ID = "id";
    protected static final String ENTITY = "entity";
    private static final String PAGE_NUM = "page_num";
    public static final String USER_ID = "user_id";
    private static final String PAGES = "numPages";
    private static final String COUNT_PAGES = "countPages";
    private static final String CURRENT_PAGE = "current_page";
    private static final String INSERT_PAGE_NUM = "insertPageNum";
    private static final String ENTITY_LIST = "entities";

    private String pathPageEdit;
    private String pathPageList;

    private final CommonService<T> commonService;

    private final UserService userService;

    public CommonController(String pathPageEdit, String pathPageList, UserService userService, CommonService<T> commonService) {
        this.pathPageEdit = pathPageEdit;
        this.pathPageList = pathPageList;
        Assert.notNull(userService, "userService must not be Null!");
        this.userService = userService;
        Assert.notNull(commonService, "commonService must not be Null!");
        this.commonService = commonService;
    }

    protected User getSecurityUser(Model model) {

        String userLogin = getPrincipal();
        if (userLogin != null)
            try {
                return userService.getUserByLogin(userLogin);
            } catch (Exception e) {
                handleException(e, model);
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

    protected String getPage(Map<String, String> paramMap, Model model) {
        model.addAttribute("show_error", "false");
        String command = paramMap.get(COMMAND);
        if (command != null)
            switch (command) {
                case COMMAND_ADD:
                    return insert(paramMap, model);
                case COMMAND_DEL:
                    return delete(paramMap, model);
                case COMMAND_EDIT:
                    return getEditPage(paramMap, model);
                case COMMAND_UPD:
                    return update(paramMap, model);
            }
        return fillModelPage(paramMap, model);
    }

    protected T findById(Map<String, String> paramMap, Model model) {
        T entity = null;
        Integer id = getParamIntDef(paramMap, ID, -1);
        if (id > 0)
            try {
                entity = commonService.getById(id);
            } catch (Exception e) {
                handleException(e, model);
            }
        return entity;
    }

    private String insert(Map<String, String> paramMap, Model model) {
        Object entity = model.asMap().get(ENTITY);
        if (entity != null)
            try {
                commonService.add((T) entity);
            } catch (Exception e) {
                handleException(e, model);
            }
        return fillModelPage(paramMap, model);
    }

    private String delete(Map<String, String> paramMap, Model model) {
        try {
            commonService.delete(getParamIntDef(paramMap, ID, -1));
        } catch (RestClientException e) {
            String s1 = ((RestClientResponseException) e).getResponseBodyAsString();
            String begTag = "<body><h1>";
            String endTag = "</h1>";
            Integer index = s1.indexOf(begTag);
            if (index > 0) {
                index += begTag.length();
                s1 = s1.substring(index);
                index = s1.indexOf(endTag);
                if (index > 0) {
                    s1 = s1.substring(0, index);
                }
                log.info(s1);
                handleException(e, model, s1);
            } else
                handleException(e, model);
        } catch (Exception e1) {
            handleException(e1, model);
        }
        return fillModelPage(paramMap, model);
    }

    protected T update(T entity, Model model) {
        if (entity != null)
            try {
                commonService.update(entity);
                entity = commonService.getById(entity.getId());
            } catch (Exception e) {
                handleException(e, model);
            }
        return entity;
    }

    private String update(Map<String, String> paramMap, Model model) {
        update((T) model.asMap().get(ENTITY), model);
        return fillModelPage(paramMap, model);
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

    protected String getEditPage(Map<String, String> paramMap, Model model) {
        model.addAttribute(CURRENT_PAGE, getParamIntDef(paramMap, PAGE_NUM, 1));
        return pathPageEdit;
    }

    private String fillModelPage(Map<String, String> paramMap, Model model) {
        model.addAttribute(ENTITY_LIST, preparePagination(getParamIntDef(paramMap, PAGE_NUM, 1), model));
        return pathPageList;
    }

    private List<Integer> getPageNumbers(Integer size) {
        List<Integer> listPages = new ArrayList<>();
        for (Integer i = 0; i < size; ) {
            listPages.add(++i);
        }
        return listPages;
    }

    private List<T> preparePagination(Integer number, Model model) {
        try {
            CommonEntityList<T> page = commonService.getPage(number, PAGE_SIZE);
            // set pages
            List<Integer> pages = getPageNumbers(page.getTotalPages());
            model.addAttribute(PAGES, pages);
            model.addAttribute(COUNT_PAGES, pages.size());

            // set current page
            if (page.getTotalPages() > 0 && number != null) {
                if (number > page.getTotalPages())
                    number = page.getTotalPages();
            } else {
                number = 1;
            }
            model.addAttribute(CURRENT_PAGE, number);

            // set num page for new record
            try {
                model.addAttribute(INSERT_PAGE_NUM, Integer.parseInt(page.getTotalElements()) / PAGE_SIZE + 1);
            } catch (Exception e) {
                handleException(e, model);
                model.addAttribute(INSERT_PAGE_NUM, 1);
            }
            return page.getEntities();
        } catch (Exception e) {
            handleException(e, model);
        }
        return null;
    }

    private void handleException(Exception e, Model model) {
        handleException(e, model, null);
    }

    private void handleException(Exception e, Model model, String description) {
        log.error(e);
        model.addAttribute("show_error", "true");
        String br = "<br/><br/>";
        StringBuilder msg = new StringBuilder(e.getMessage());
        if (e.getCause() != null && e.getCause().getMessage() != null)
            msg.append(br).append(e.getCause().getMessage());
        if (description != null)
            msg.append(br).append(description);
        model.addAttribute("text_error", msg.toString());
    }
}
