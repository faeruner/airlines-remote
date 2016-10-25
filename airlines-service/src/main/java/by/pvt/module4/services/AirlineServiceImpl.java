package by.pvt.module4.services;

import by.pvt.module4.model.Airline;
import by.pvt.module4.rest.common.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service("airlineService")
public class AirlineServiceImpl extends CommonServiceImpl<Airline> implements AirlineService {
}
