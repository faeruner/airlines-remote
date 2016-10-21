package by.pvt.module4.common;

import java.util.List;

public interface CommonEntityList<T extends Fact> {
    List<T> getEntity();

    void setEntity(List<T> entity);
}
