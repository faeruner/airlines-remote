package by.pvt.module4.services;

import by.pvt.module4.model.Crew;
import by.pvt.module4.model.Staff;
import by.pvt.module4.rest.common.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("crewService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CrewServiceImpl extends CommonServiceImpl<Crew> implements CrewService {

    @Autowired
    protected StaffService staffService;

    @Override
    public Crew findOne(Integer id, Boolean full) {
        Crew crew = super.findOne(id, full);
        if(full) crew.getMembers().iterator();
        return crew;
    }

    @Override
    @Transactional()
    public Crew save(Crew entity) {
        Set<Staff> staffs = new HashSet<>();
        entity.getMembers().forEach(staffs::add);
        entity.getMembers().clear();
        super.save(entity);
        entity.setMembers(staffs);
        return super.save(entity);
    }

    @Override
    public Page<Crew> findPage(Pageable page, Boolean full) {
        Page<Crew> crews = super.findPage(page, full);
        if(full) crews.forEach(item -> item.getMembers().iterator());
        return crews;
    }

    @Override
    public List<Crew> findAll(Boolean full) {
        List<Crew> crews = super.findAll(full);
        if(full) crews.forEach(item -> item.getMembers().iterator());
        return crews;
    }
}
