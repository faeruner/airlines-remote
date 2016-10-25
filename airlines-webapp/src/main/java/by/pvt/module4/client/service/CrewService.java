package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.Crew;
import by.pvt.module4.model.Crews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CrewService extends CommonServiceImpl<Crew, Crews> {
    @Autowired
    public CrewService(RestTemplate restTemplate, Environment env) {
        super(restTemplate, env, "crew");
    }
}
