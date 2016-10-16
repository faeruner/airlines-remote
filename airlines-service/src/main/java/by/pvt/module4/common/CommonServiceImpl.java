package by.pvt.module4.common;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public abstract class CommonServiceImpl<T extends Fact> implements CommonService<T> {

    @Autowired
    protected CommonRepository<T> commonRepository;

    @Override
    public T findById(Integer id) {
        return findById(id, true);
    }

    @Override
    public T findById(Integer id, Boolean full) {
        return commonRepository.findOne(id);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        commonRepository.delete(entity);
    }

    @Override
    @Transactional
    public T save(T entity) {
        return commonRepository.save(entity);
    }

    @Override
    public List<T> findPage(Integer page, Integer size) {
        return findPage(page, size, true);
    }

    @Override
    public List<T> findPage(Integer page, Integer size, Boolean full) {
        return null;
    }

    @Override
    public List<T> findAll(Boolean full) {
        return Lists.newArrayList(commonRepository.findAll());
    }

    @Override
    public List<T> findAll() {
        return findAll(true);
    }

    @Override
    public List<Integer> getPageNumbers(Integer size) {
        return null;
    }

    @Override
    public Long getInsertPageNum(Integer size) {
        return null;
    }
}
