package by.pvt.module4.model;

import by.pvt.module4.common.CommonEntityListImpl;

import java.util.List;

public class Crews extends CommonEntityListImpl<Crew> {

    public Crews() {
        super();
    }

    public Crews(List<Crew> crews) {
        super(crews);
    }

    public List<Crew> getCrews() {
        return getEntity();
    }

    public void setCrews(List<Crew> crews) {
        setEntity(crews);
    }
}

