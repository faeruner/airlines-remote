package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Airline;
import by.pvt.module4.model.Airlines;
import org.springframework.stereotype.Service;

@Service
public class AirlineService extends CommonServiceImpl<Airline, Airlines> {
    public AirlineService() {
        super("airline");
    }
}
