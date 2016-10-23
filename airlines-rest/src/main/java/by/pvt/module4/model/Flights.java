package by.pvt.module4.model;

import by.pvt.module4.common.CommonEntityListImpl;

import java.util.List;

/**
 * Created by v on 23.10.2016.
 */
public class Flights extends CommonEntityListImpl<Flight> {
    public Flights() {
        super();
    }

    public Flights(List<Flight> flights) {
        super(flights);
    }

    public List<Flight> getFlights() {
        return getEntity();
    }

    public void setFlights(List<Flight> flights) {
        setEntity(flights);
    }
}
