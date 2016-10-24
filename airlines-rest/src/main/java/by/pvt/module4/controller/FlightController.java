package by.pvt.module4.controller;

import by.pvt.module4.common.CommonController;
import by.pvt.module4.model.Flight;
import by.pvt.module4.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/flight")
public class FlightController extends CommonController<Flight> {

    @Autowired
    public FlightController(FlightService flightService) {
        super(flightService);
    }

}
