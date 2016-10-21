package by.pvt.module3.service;

import by.pvt.module3.dao.common.CommonDao;
import by.pvt.module3.entity.MemberType;
import by.pvt.module3.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberTypeService extends BaseService<MemberType> {
    @Autowired
    public MemberTypeService(CommonDao<MemberType> dao) {
        super(dao);
    }
}
