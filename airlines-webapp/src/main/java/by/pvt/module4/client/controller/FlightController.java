package by.pvt.module4.client.controller;

import by.pvt.module4.client.common.CommonController;
import by.pvt.module4.client.common.CommonService;
import by.pvt.module4.client.service.UserService;
import by.pvt.module4.model.*;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/controller/flight", method = {RequestMethod.GET, RequestMethod.POST})
public class FlightController extends CommonController<Flight> {
    private Logger log = LogManager.getLogger(FlightController.class);
    private static final String LIST_DEPARTURE = "departure";
    private static final String LIST_ARRIVAL = "arrival";
    private static final String LIST_AIRLINE = "airline";
    private static final String LIST_CREW = "crew";

    private final CommonService<Airport> airportService;
    private final CommonService<Airline> airlineService;
    private final CommonService<Crew> crewService;

    @Autowired
    public FlightController(UserService userService, CommonService<Flight> commonService, CommonService<Crew> crewService, CommonService<Airline> airlineService, CommonService<Airport> airportService) {
        super("flight-edit", "flight-list", userService, commonService);
        Assert.notNull(crewService, "crewService must not be Null!");
        this.crewService = crewService;
        Assert.notNull(airlineService, "airlineService must not be Null!");
        this.airlineService = airlineService;
        Assert.notNull(airportService, "airportService must not be Null!");
        this.airportService = airportService;
    }

    @RequestMapping
    public String perform(@RequestParam Map<String, String> paramMap, Model model) {
        List<Airport> listAirports = airportService.getAll();
        model.addAttribute(LIST_DEPARTURE, listAirports);
        model.addAttribute(LIST_ARRIVAL, listAirports);
        model.addAttribute(LIST_AIRLINE, airlineService.getAll());
        model.addAttribute(LIST_CREW, crewService.getAll());
        model.addAttribute(CommonController.ENTITY, updateEntity(findById(paramMap, model), paramMap, getSecurityUser(model)));
        return getPage(paramMap, model);
    }

    private Flight updateEntity(Flight flight, Map<String, String> paramMap, User user) {
        if (flight == null)
            flight = new Flight();

        if (paramMap.containsKey(Flight.CODE)) flight.setCode(paramMap.get(Flight.CODE).trim());
        try {
            if (paramMap.containsKey(Flight.DEPARTURE_DATE))
                flight.setDepDate(DF.parse(paramMap.get(Flight.DEPARTURE_DATE).trim()));
            if (paramMap.containsKey(Flight.RETURN_DATE))
                flight.setReturnDate(DF.parse(paramMap.get(Flight.RETURN_DATE).trim()));
            if (paramMap.containsKey(Flight.CREATE_DATE))
                flight.setCreateDate(DF.parse(paramMap.get(Flight.CREATE_DATE).trim()));
            else if (flight.getCreateDate() == null) flight.setCreateDate(new Date());
        } catch (ParseException e) {
            log.error(e);
        }

        if (paramMap.containsKey(Flight.AIRPORT_ARV_ID)) flight.setArrival(airportService.
                getById(getParamIntDef(paramMap, Flight.AIRPORT_ARV_ID, -1)));
        if (paramMap.containsKey(Flight.AIRPORT_DEP_ID)) flight.setDeparture(airportService.
                getById(getParamIntDef(paramMap, Flight.AIRPORT_DEP_ID, -1)));
        if (paramMap.containsKey(Flight.AIRLINE_ID)) flight.setAirline(airlineService.
                getById(getParamIntDef(paramMap, Flight.AIRLINE_ID, -1)));
        if (paramMap.containsKey(Flight.CREW_ID)) flight.setCrew(crewService.
                getById(getParamIntDef(paramMap, Flight.CREW_ID, -1)));

        flight.setUser(user);

        return flight;
    }
}

