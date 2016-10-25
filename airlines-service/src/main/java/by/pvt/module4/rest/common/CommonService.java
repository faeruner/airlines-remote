package by.pvt.module4.rest.common;

import by.pvt.module4.common.Fact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommonService<T extends Fact> {

    T findOne(Integer id);

    T findOne(Integer id, Boolean full);

    Page<T> findPage(Pageable page);

    Page<T> findPage(Pageable page, Boolean full);

    List<T> findAll();

    List<T> findAll(Boolean full);

    void delete(T entity);

    T save(T entity);

/*
    List<Integer> getPageNumbers(Integer size);

    Long getInsertPageNum(Integer size);
*/
}
