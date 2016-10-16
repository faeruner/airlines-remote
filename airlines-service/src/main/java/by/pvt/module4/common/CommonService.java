package by.pvt.module4.common;

import java.util.List;

public interface CommonService<T extends Fact> {

    T findById(Integer id);

    T findById(Integer id, Boolean full);

    List<T> findPage(Integer page, Integer size);

    List<T> findPage(Integer page, Integer size, Boolean full);

    List<T> findAll();

    List<T> findAll(Boolean full);

    void delete(T entity);

    T save(T entity);

    List<Integer> getPageNumbers(Integer size);

    Long getInsertPageNum(Integer size);
}
