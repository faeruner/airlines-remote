package by.pvt.module4.services;

import by.pvt.module4.common.CommonServiceImpl;
import by.pvt.module4.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by v on 21.10.2016.
 */
@Service("flightService")
public class FlightServiceImpl extends CommonServiceImpl<Flight> implements FlightService {


}
