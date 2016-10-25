package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.MemberType;
import by.pvt.module4.model.MemberTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberTypeService extends CommonServiceImpl<MemberType, MemberTypes> {
    @Autowired
    public MemberTypeService(RestTemplate restTemplate, Environment env) {
        super(restTemplate, env, "membertype");
    }
}
