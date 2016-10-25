package by.pvt.module4.client.controller;

import by.pvt.module4.client.common.CommonController;
import by.pvt.module4.client.common.CommonService;
import by.pvt.module4.client.service.UserService;
import by.pvt.module4.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = "/controller/airline", method = {RequestMethod.GET, RequestMethod.POST})
@PropertySource("classpath:messages.properties")
public class AirlineController extends CommonController<Airline> {

    @Autowired
    private Environment env;

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
    public void validate(@RequestParam Map<String, String> paramMap, Model model, HttpServletResponseWrapper response) {
        if (paramMap.containsKey(Airline.NAME)) {
            String name = paramMap.get(Airline.NAME).trim();
            if (name.toLowerCase().contains("error")) {
                try {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, env.getProperty("message.wrong.name"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Airline updateEntity(Airline airline, Map<String, String> paramMap) {
        if (airline == null)
            airline = new Airline();
        if (paramMap.containsKey(Airline.NAME))
            airline.setName(paramMap.get(Airline.NAME).trim());
        return airline;
    }
}
