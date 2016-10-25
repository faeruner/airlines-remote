package by.pvt.module4.client.common;

import by.pvt.module4.common.CommonEntityList;
import by.pvt.module4.common.Fact;

import java.util.List;

public interface CommonService<T extends Fact> {
    T getById(Integer id);

    void delete(Integer id);

    Integer add(T entity);

    void update(T entity);

    CommonEntityList<T> getPage(Integer page, Integer size);

    List<T> getAll();

}
