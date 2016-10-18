package by.pvt.module4.controller;

import by.pvt.module4.common.CommonController;
import by.pvt.module4.model.Airline;
import by.pvt.module4.model.Airlines;
import by.pvt.module4.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/airline")
public class AirlineController extends CommonController<Airline> {

    @Autowired
    private AirlineService airlineService;

    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    @ResponseBody
    public Airlines listData() {
        return new Airlines(airlineService.findAll());
    }

    @RequestMapping(value = "/pagedata", method = RequestMethod.GET)
    @ResponseBody
    public Airlines pageData(@RequestParam Map<String, String> paramMap) {
        return new Airlines(findPage(paramMap, airlineService));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Airline findAirlineOne(@PathVariable Integer id) {
        return airlineService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Airline create(@RequestBody Airline airline) {
        log.info("Creating airline: " + airline);
        airlineService.save(airline);
        log.info("Airline created successfully with info: " + airline);
        return airline;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Airline airline,
                       @PathVariable Integer id) {
        log.info("Updating airline: " + airline);
        airlineService.save(airline);
        log.info("Airline updated successfully with info: " + airline);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        log.info("Deleting contact with id: " + id);
        Airline airline = airlineService.findOne(id);
        airlineService.delete(airline);
        log.info("Airline deleted successfully");
    }
}
