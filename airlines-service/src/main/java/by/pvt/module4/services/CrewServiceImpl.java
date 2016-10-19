package by.pvt.module4.services;

import by.pvt.module4.common.CommonServiceImpl;
import by.pvt.module4.model.Crew;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("crewService")
@Transactional(readOnly = true)
public class CrewServiceImpl extends CommonServiceImpl<Crew> implements CrewService {

    @Override
    public Crew findOne(Integer id, Boolean full) {
        Crew crew = super.findOne(id, full);
        if(full) crew.getMembers().iterator();
        return crew;
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
