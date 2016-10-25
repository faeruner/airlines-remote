package by.pvt.module4.common;

import java.util.List;

public interface CommonEntityList<T extends Fact> {
    List<T> getEntities();

    void setEntities(List<T> entities);

    Integer getTotalPages();

    String getTotalElements();

    void setTotalPages(Integer totalPages);

    void setTotalElements(String totalElements);
}
