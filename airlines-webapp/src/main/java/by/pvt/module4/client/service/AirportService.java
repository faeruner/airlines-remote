package by.pvt.module3.service;

import by.pvt.module3.dao.common.CommonDao;
import by.pvt.module3.entity.Airport;
import by.pvt.module3.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService extends BaseService<Airport> {
    @Autowired
    public AirportService(CommonDao<Airport> dao) {
        super(dao);
    }
}
