package by.pvt.module4.services;

import by.pvt.module4.model.MemberType;
import by.pvt.module4.rest.common.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service("memberTypeService")
public class MemberTypeServiceImpl extends CommonServiceImpl<MemberType> implements MemberTypeService {
}
