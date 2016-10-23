package by.pvt.module4.controller;

import by.pvt.module4.common.CommonController;
import by.pvt.module4.model.Flight;
import by.pvt.module4.model.Flights;
import by.pvt.module4.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by v on 23.10.2016.
 */
public class FlightController extends CommonController<Flight> {
    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    @ResponseBody
    public Flights listData() {
        return new Flights(flightService.findAll());
    }

    @RequestMapping(value = "/pagedata", method = RequestMethod.GET)
    @ResponseBody
    public Flights pageData(@RequestParam Map<String, String> paramMap) {
        return new Flights(findPage(paramMap, flightService));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Flight findFlightOne(@PathVariable Integer id) {
        return flightService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Flight create(@RequestBody Flight flight) {
        log.info("Creating flight: " + flight);
        flightService.save(flight);
        log.info("Flight created successfully with info: " + flight);
        return flight;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Flight flight,
                       @PathVariable Integer id) {
        log.info("Updating flight: " + flight);
        flightService.save(flight);
        log.info("Flight updated successfully with info: " + flight);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        log.info("Deleting flight with id: " + id);
        Flight flight = flightService.findOne(id);
        flightService.delete(flight);
        log.info("Flight deleted successfully");
    }
}
