package by.pvt.module4.client.service;

import by.pvt.module4.client.common.CommonServiceImpl;
import by.pvt.module4.model.MemberType;
import by.pvt.module4.model.MemberTypes;
import org.springframework.stereotype.Service;

@Service
public class MemberTypeService extends CommonServiceImpl<MemberType, MemberTypes> {
    public MemberTypeService() {
        super("membertype");
    }
}
