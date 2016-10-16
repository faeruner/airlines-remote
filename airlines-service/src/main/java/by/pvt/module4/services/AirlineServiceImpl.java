package by.pvt.module4.services;

import by.pvt.module4.common.CommonServiceImpl;
import by.pvt.module4.model.Airline;
import org.springframework.stereotype.Service;

@Service("airlineService")
public class AirlineServiceImpl extends CommonServiceImpl<Airline> implements AirlineService {
}
