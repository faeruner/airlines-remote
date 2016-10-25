package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Airline;
import by.pvt.module4.model.Airlines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirlineService extends CommonServiceImpl<Airline, Airlines> {
    @Autowired
    public AirlineService(RestTemplate restTemplate, Environment env) {
        super(restTemplate, env, "airline");
    }
}
