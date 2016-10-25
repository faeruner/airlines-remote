package by.pvt.module4.client.controller;

import by.pvt.module4.client.common.CommonController;
import by.pvt.module4.client.common.CommonService;
import by.pvt.module4.client.service.UserService;
import by.pvt.module4.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = "/controller/airline", method = {RequestMethod.GET, RequestMethod.POST})
public class AirlineController extends CommonController<Airline> {

    @Autowired
    public AirlineController(UserService userService, CommonService<Airline> commonService) {
        super("airline-edit", "airline-list", userService, commonService);
    }

    @RequestMapping
    public String perform(@RequestParam Map<String, String> paramMap, Model model) {
        model.addAttribute(ENTITY, updateEntity(findById(paramMap, model), paramMap));
        return getPage(paramMap, model);
    }

    @RequestMapping("/validate")
    public String validate(@RequestParam Map<String, String> paramMap, Model model, HttpServletResponse response) {
        if (paramMap.containsKey(Airline.NAME)) {
            String name = paramMap.get(Airline.NAME).trim();
            if (!name.toLowerCase().contains("airline")) {
                try {
                    response.setContentType("text/html;charset=UTF-8");
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    //model.addAttribute("msg_wrong_name", "ошибка в имени");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute(ENTITY, updateEntity(findById(paramMap, model), paramMap));
        return getEditPage(paramMap, model);
    }

    private Airline updateEntity(Airline airline, Map<String, String> paramMap) {
        if (airline == null)
            airline = new Airline();
        if (paramMap.containsKey(Airline.NAME))
            airline.setName(paramMap.get(Airline.NAME).trim());
        return airline;
    }
}
