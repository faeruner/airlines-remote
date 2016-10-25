package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Flight;
import by.pvt.module4.model.Flights;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends CommonServiceImpl<Flight, Flights> {
    public FlightService() {
        super("flight");
    }
}
