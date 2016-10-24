package by.pvt.module4.common;

import java.util.List;

public interface CommonEntityList<T extends Fact> {
    List<T> getEntities();

    void setEntities(List<T> entities);

    Integer getTotalPages();

    Long getTotalElements();

    void setTotalPages(Integer totalPages);

    void setTotalElements(Long totalElements);
}
