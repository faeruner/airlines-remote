package by.pvt.module4.client.controller;

import by.pvt.module4.client.common.CommonController;
import by.pvt.module4.client.common.CommonService;
import by.pvt.module4.client.service.UserService;
import by.pvt.module4.model.Crew;
import by.pvt.module4.model.Staff;
import by.pvt.module4.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/controller/crew", method = {RequestMethod.GET, RequestMethod.POST})
public class CrewController extends CommonController<Crew> {

    private Logger log = LogManager.getLogger(CrewController.class);
    private final static String CHECKED = "checked";
    private final static String STAFF = "staff";
    private final static String READY_NO = "readyNo";
    private final static String READY_YES = "readyYes";
    private static final String MEMBER = "member";

    private final CommonService<Staff> staffService;

    @Autowired
    public CrewController(UserService userService, CommonService<Crew> commonService, CommonService<Staff> staffService) {
        super("path.page.edit_crew", "path.page.crews", userService, commonService);
        Assert.notNull(staffService, "staffService must not be Null!");
        this.staffService = staffService;
    }

    @RequestMapping
    String perform(@RequestParam Map<String, String> paramMap, Model model) {
        Crew crew = updateEntity(findById(paramMap, model), paramMap, getSecurityUser(model));

        String memberCommand = paramMap.get(MEMBER);
        if (memberCommand != null) {
            switch (memberCommand) {
                case COMMAND_ADD:
                    Staff staff = staffService.getById(Integer.parseInt(paramMap.get(Crew.STAFF_ID).trim()));
                    crew.getMembers().add(staff);
                    break;
                case COMMAND_DEL:
                    Integer staff_id = Integer.parseInt(paramMap.get(Crew.STAFF_ID).trim());
                    for (Staff item : crew.getMembers()) {
                        if (item.getId().equals(staff_id)) {
                            crew.getMembers().remove(item);
                            break;
                        }
                    }
                    break;
            }
            update(crew, model);
        }
        List<Staff> staff = staffService.getAll();
        for (Staff member : crew.getMembers()) {
            staff.removeIf(s -> s.getId().equals(member.getId()));
        }
        model.addAttribute(STAFF, staff);

        String readyNo = CHECKED;
        String readyYes = "";
        if (crew.getReady() > 0) {
            readyNo = "";
            readyYes = CHECKED;
        }
        model.addAttribute(READY_NO, readyNo);
        model.addAttribute(READY_YES, readyYes);

        model.addAttribute(ENTITY, crew);
        if (memberCommand != null) {
            return getEditPage(paramMap, model);
        } else {
            return getPage(paramMap, model);
        }

    }

    private Crew updateEntity(Crew crew, Map<String, String> paramMap, User user) {
        if (crew == null) {
            crew = new Crew();
            crew.setMembers(new HashSet<>());
            crew.setCreateDate(new Date());
        }
        try {
            if (paramMap.containsKey(Crew.CREATE_DATE))
                crew.setCreateDate(DF.parse(paramMap.get(Crew.CREATE_DATE).trim()));
        } catch (ParseException e) {
            log.error(e);
        }
        crew.setReady(getParamIntDef(paramMap, Crew.READY, 0));
        crew.setUser(user);
        return crew;
    }
}
