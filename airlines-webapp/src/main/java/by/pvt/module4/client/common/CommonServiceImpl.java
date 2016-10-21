package by.pvt.module4.client.common;

import by.pvt.module4.common.CommonEntityList;
import by.pvt.module4.common.Fact;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonServiceImpl<T extends Fact, A extends CommonEntityList<T>> implements CommonService<T> {

    private static final String PROP_REST_PATH = "rest.path";
    private static final String PROP_REST_GET_ALL = "rest.suffix.getAll";
    private static final String PROP_REST_GET_BY_ID = "rest.suffix.getById";
    private static final String PROP_REST_CREATE = "rest.suffix.create";
    private static final String PROP_REST_UPDATE = "rest.suffix.update";
    private static final String PROP_REST_DELETE = "rest.suffix.delete";

    private final Environment env;

    private final RestTemplate restTemplate;

    private final Class<T> clazz;

    private final String entityName;

    public CommonServiceImpl(RestTemplate restTemplate, Environment env, String entityName) {
        this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Assert.notNull(env, "Environment must not be null!");
        this.env = env;
        Assert.notNull(restTemplate, "RestTemplate must not be null!");
        this.restTemplate = restTemplate;
        this.entityName = entityName;
    }

    public T getById(Integer id) {
        String path = String.format(env.getProperty(PROP_REST_PATH) + env.getProperty(PROP_REST_GET_BY_ID), entityName);
        A list = restTemplate.getForObject(path, clazz, id);
        return list.getEntity().get(0);
    }

    public void delete(Integer id) {
        getDao().delete(id);
    }

    public Integer add(T entity) {
        return getDao().add(entity);
    }

    public T update(T entity) {
        return getDao().update(entity);
    }

    public List<Integer> getPageNumbers(Integer size) {
        Long count = getDao().getCount();
        List<Integer> listPages = new ArrayList<Integer>();
        for (int i = 1; count > 0; i++) {
            listPages.add(i);
            count -= size;
        }
        return listPages;
    }

    public List<T> getAll() {
        return getDao().getAll();
    }

    public List<T> getPage(Integer page, Integer size) {
        return getDao().getPage(page, size);
    }

    public Long getInsertPageNum(Integer size) {
        Long count = getDao().getCount();
        return count / size + 1;
    }
}
