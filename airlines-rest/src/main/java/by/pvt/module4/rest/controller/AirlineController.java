package by.pvt.module4.rest.controller;

import by.pvt.module4.model.Airline;
import by.pvt.module4.rest.common.CommonController;
import by.pvt.module4.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/airline")
public class AirlineController extends CommonController<Airline> {

    @Autowired
    public AirlineController(AirlineService airlineService) {
        super(airlineService);
    }
}
