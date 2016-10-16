package by.pvt.module4.services;

import by.pvt.module4.common.CommonServiceImpl;
import by.pvt.module4.model.Crew;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("crewService")
public class CrewServiceImpl extends CommonServiceImpl<Crew> implements CrewService {

    @Override
    public Crew findById(Integer id, Boolean full) {
        Crew crew = super.findById(id, full);
        if(full) crew.getMembers().iterator();
        return crew;
    }

    @Override
    public List<Crew> findPage(Integer page, Integer size, Boolean full) {
        List<Crew> crews =  super.findPage(page, size, full);
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
