package by.pvt.module3.service;

import by.pvt.module3.dao.common.CommonDao;
import by.pvt.module3.entity.Crew;
import by.pvt.module3.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewService extends BaseService<Crew> {
    @Autowired
    public CrewService(CommonDao<Crew> dao) {
        super(dao);
    }
}
