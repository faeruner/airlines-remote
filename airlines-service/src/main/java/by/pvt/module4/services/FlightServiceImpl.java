package by.pvt.module4.services;

import by.pvt.module4.model.Flight;
import by.pvt.module4.rest.common.CommonServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by v on 21.10.2016.
 */
@Service("flightService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class FlightServiceImpl extends CommonServiceImpl<Flight> implements FlightService {

    @Override
    public Flight findOne(Integer id, Boolean full) {
        Flight flight = super.findOne(id, full);
        if (full) flight.getCrew().getMembers().iterator();
        return flight;
    }

    @Override
    public Page<Flight> findPage(Pageable page, Boolean full) {
        Page<Flight> flights = super.findPage(page, full);
        if (full) flights.forEach(item -> item.getCrew().getMembers().iterator());
        return flights;
    }

    @Override
    public List<Flight> findAll(Boolean full) {
        List<Flight> flights = super.findAll(full);
        if (full) flights.forEach(item -> item.getCrew().getMembers().iterator());
        return flights;
    }
}
