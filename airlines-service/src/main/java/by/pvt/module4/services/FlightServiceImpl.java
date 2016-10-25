package by.pvt.module4.services;

import by.pvt.module4.model.Flight;
import by.pvt.module4.rest.common.CommonServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by v on 21.10.2016.
 */
@Service("flightService")
public class FlightServiceImpl extends CommonServiceImpl<Flight> implements FlightService {
}
