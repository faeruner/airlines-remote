package by.pvt.module4.services;

import by.pvt.module4.common.CommonServiceImpl;
import by.pvt.module4.model.MemberType;
import org.springframework.stereotype.Service;

@Service("memberTypeService")
public class MemberTypeServiceImpl extends CommonServiceImpl<MemberType> implements MemberTypeService {
}
