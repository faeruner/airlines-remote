package by.pvt.module4.model;

import java.io.Serializable;
import java.util.List;

public class Crews implements Serializable {
    List<Crew> crews;

    public Crews() {
    }

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
    }
}

