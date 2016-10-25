package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Crew;
import by.pvt.module4.model.Crews;
import org.springframework.stereotype.Service;

@Service
public class CrewService extends CommonServiceImpl<Crew, Crews> {
    public CrewService() {
        super("crew");
    }
}
