package by.pvt.module4.rest.controller;

import by.pvt.module4.model.Airport;
import by.pvt.module4.model.Airports;
import by.pvt.module4.rest.common.CommonController;
import by.pvt.module4.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/airport")
public class AirportController extends CommonController<Airport, Airports> {

    @Autowired
    public AirportController(AirportService service) {
        super(service);
    }
}
