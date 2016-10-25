package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Flight;
import by.pvt.module4.model.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightService extends CommonServiceImpl<Flight, Flights> {
    @Autowired
    public FlightService(RestTemplate restTemplate, Environment env) {
        super(restTemplate, env, "flight");
    }
}
