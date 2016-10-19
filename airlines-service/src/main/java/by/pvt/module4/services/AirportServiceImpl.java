package by.pvt.module4.services;

import by.pvt.module4.common.CommonServiceImpl;
import by.pvt.module4.model.Airport;
import org.springframework.stereotype.Service;

@Service("airportService")
public class AirportServiceImpl extends CommonServiceImpl<Airport> implements AirportService {
}
