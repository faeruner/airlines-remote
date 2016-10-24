package by.pvt.module4.client.common;

import by.pvt.module4.common.CommonEntityList;
import by.pvt.module4.common.Fact;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonServiceImpl<T extends Fact, L extends CommonEntityList<T>> implements CommonService<T> {

    private static final String PROP_REST_PATH = "rest.path";
    private static final String PROP_REST_GET_ALL = "rest.suffix.getAll";
    private static final String PROP_REST_GET_PAGE = "rest.suffix.getPage";
    private static final String PROP_REST_GET_BY_ID = "rest.suffix.getById";
    private static final String PROP_REST_CREATE = "rest.suffix.create";
    private static final String PROP_REST_UPDATE = "rest.suffix.update";
    private static final String PROP_REST_DELETE = "rest.suffix.delete";

    private final Environment env;

    private final RestTemplate restTemplate;

    private final Class<T> clazz;
    private final Class<L> listClazz;

    private final String entityName;

    public CommonServiceImpl(RestTemplate restTemplate, Environment env, String entityName) {
        this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.listClazz = (Class<L>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Assert.notNull(env, "Environment must not be null!");
        this.env = env;
        Assert.notNull(restTemplate, "RestTemplate must not be null!");
        this.restTemplate = restTemplate;
        this.entityName = entityName;
    }

    private String getPath(String suffix) {
        return String.format(env.getProperty(PROP_REST_PATH) + env.getProperty(suffix), entityName);
    }

    public T getById(Integer id) {
        return restTemplate.getForObject(getPath(PROP_REST_GET_BY_ID), clazz, id);
        ;
    }

    public void delete(Integer id) {
        restTemplate.delete(getPath(PROP_REST_DELETE), id);
    }

    public Integer add(T entity) {
        return restTemplate.postForObject(getPath(PROP_REST_CREATE), entity, clazz).getId();
    }

    public void update(T entity) {
        restTemplate.put(PROP_REST_UPDATE, entity, entity.getId());
    }

    public List<T> getAll() {
        L list = restTemplate.getForObject(getPath(PROP_REST_GET_ALL), listClazz);
        return list.getEntities();
    }

    public List<T> getPage(Integer page, Integer size) {
        L list = restTemplate.getForObject(getPath(PROP_REST_GET_PAGE), listClazz, page, size);
        return list.getEntities();
    }

    public Long getInsertPageNum(Integer size) {
        Long count = getDao().getCount();
        return count / size + 1;
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
}
