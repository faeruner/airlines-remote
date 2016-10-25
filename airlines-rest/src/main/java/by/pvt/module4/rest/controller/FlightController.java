package by.pvt.module4.rest.controller;

import by.pvt.module4.model.Flight;
import by.pvt.module4.model.Flights;
import by.pvt.module4.rest.common.CommonController;
import by.pvt.module4.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/flight")
public class FlightController extends CommonController<Flight, Flights> {

    @Autowired
    public FlightController(FlightService flightService) {
        super(flightService);
    }

}
