package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Airport;
import by.pvt.module4.model.Airports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirportService extends CommonServiceImpl<Airport, Airports> {
    @Autowired
    public AirportService(RestTemplate restTemplate, Environment env) {
        super(restTemplate, env, "airport");
    }
}
