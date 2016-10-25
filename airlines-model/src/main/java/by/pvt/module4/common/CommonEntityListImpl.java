package by.pvt.module4.common;

import java.io.Serializable;
import java.util.List;

public class CommonEntityListImpl<T extends Fact> implements Serializable, CommonEntityList<T> {

    private List<T> entities;
    private String totalElements;
    private Integer totalPages;

    public CommonEntityListImpl() {
    }

    public CommonEntityListImpl(List<T> entities) {
        this.entities = entities;
    }

    @Override
    public List<T> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    @Override
    public Integer getTotalPages() {
        return totalPages;
    }

    @Override
    public String getTotalElements() {
        return totalElements;
    }

    @Override
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public void setTotalElements(String totalElements) {
        this.totalElements = totalElements;
    }
}
