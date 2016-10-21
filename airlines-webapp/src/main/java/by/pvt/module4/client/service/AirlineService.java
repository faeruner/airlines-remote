package by.pvt.module3.service;

import by.pvt.module3.dao.common.CommonDao;
import by.pvt.module3.entity.Airline;
import by.pvt.module3.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService extends BaseService<Airline> {
    @Autowired
    public AirlineService(CommonDao<Airline> dao) {
        super(dao);
    }
}
