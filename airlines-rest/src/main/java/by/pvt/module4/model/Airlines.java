package by.pvt.module4.model;

import by.pvt.module4.common.CommonEntityListImpl;

import java.util.List;

public class Airlines extends CommonEntityListImpl<Airline> {

    public Airlines() {
        super();
    }

    public Airlines(List<Airline> airlines) {
        super(airlines);
    }

    public List<Airline> getAirlines() {
        return getEntity();
    }

    public void setAirlines(List<Airline> airlines) {
        setEntity(airlines);
    }
}
