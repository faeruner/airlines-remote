package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Airport;
import by.pvt.module4.model.Airports;
import org.springframework.stereotype.Service;

@Service
public class AirportService extends CommonServiceImpl<Airport, Airports> {
    public AirportService() {
        super("airport");
    }
}
