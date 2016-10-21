package by.pvt.module4.common;

import java.io.Serializable;
import java.util.List;

public class CommonEntityListImpl<T extends Fact> implements Serializable, CommonEntityList<T> {

    List<T> entity;

    public CommonEntityListImpl() {
    }

    public CommonEntityListImpl(List<T> entity) {
        this.entity = entity;
    }

    @Override
    public List<T> getEntity() {
        return entity;
    }

    @Override
    public void setEntity(List<T> entity) {
        this.entity = entity;
    }
}
