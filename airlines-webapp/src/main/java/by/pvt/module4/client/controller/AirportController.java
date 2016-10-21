package by.pvt.module3.controller;

import by.pvt.module3.controller.common.CommonController;
import by.pvt.module3.entity.Airport;
import by.pvt.module3.service.UserService;
import by.pvt.module3.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping(value = "/controller/airport", method = {RequestMethod.GET, RequestMethod.POST})
public class AirportController extends CommonController<Airport> {
    @Autowired
    public AirportController(UserService userService, CommonService<Airport> commonService) {
        super("path.page.edit_airport", "path.page.airports", userService, commonService);
    }

    @RequestMapping
    public String perform(@RequestParam Map<String, String> paramMap, Model model) {
        model.addAttribute(ENTITY, updateEntity(findById(paramMap, model), paramMap));
        return getPage(paramMap, model);
    }

    private Airport updateEntity(Airport airport, Map<String, String> paramMap) {
        if (airport == null)
            airport = new Airport();
        if (paramMap.containsKey(Airport.NAME))
            airport.setName(paramMap.get(Airport.NAME).trim());
        return airport;
    }
}
