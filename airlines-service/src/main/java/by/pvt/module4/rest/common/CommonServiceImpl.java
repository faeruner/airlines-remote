package by.pvt.module4.rest.common;

import by.pvt.module4.common.CommonRepository;
import by.pvt.module4.common.Fact;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public abstract class CommonServiceImpl<T extends Fact> implements CommonService<T> {

    @Autowired
    protected CommonRepository<T> commonRepository;

    @Override
    public T findOne(Integer id) {
        return findOne(id, true);
    }

    @Override
    public T findOne(Integer id, Boolean full) {
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
    public Page<T> findPage(Pageable page) {
        return findPage(page, true);
    }

    @Override
    public Page<T> findPage(Pageable page, Boolean full) {
        Page<T> resultPage = commonRepository.findAll(page);
        if (page.getPageNumber() > 0 && resultPage.getTotalPages() < page.getPageNumber() + 1) {
            page = new PageRequest(page.getPageNumber() - 1, page.getPageSize());
            resultPage = findPage(page, full);
        }
        return resultPage;
    }

    @Override
    public List<T> findAll(Boolean full) {
        return Lists.newArrayList(commonRepository.findAll());
    }

    @Override
    public List<T> findAll() {
        return findAll(true);
    }

}
