package by.pvt.module3.service;

import by.pvt.module3.dao.common.CommonDao;
import by.pvt.module3.entity.Flight;
import by.pvt.module3.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends BaseService<Flight> {
    @Autowired
    public FlightService(CommonDao<Flight> dao) {
        super(dao);
    }
}
