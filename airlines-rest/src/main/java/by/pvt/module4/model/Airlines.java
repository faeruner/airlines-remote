package by.pvt.module4.model;

import java.io.Serializable;
import java.util.List;

public class Airlines implements Serializable {
    List<Airline> airlines;

    public Airlines() {
    }

    public Airlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }
}
