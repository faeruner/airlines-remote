package by.pvt.module4.client.common;

import by.pvt.module4.common.CommonEntityList;
import by.pvt.module4.common.CommonEntityListImpl;
import by.pvt.module4.common.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@PropertySource("classpath:config.properties")
public abstract class CommonServiceImpl<T extends Fact, L extends CommonEntityListImpl<T>> implements CommonService<T> {

    private static final String PROP_REST_PATH = "rest.path";
    private static final String PROP_REST_GET_ALL = "rest.suffix.getAll";
    private static final String PROP_REST_GET_PAGE = "rest.suffix.getPage";
    private static final String PROP_REST_GET_BY_ID = "rest.suffix.getById";
    private static final String PROP_REST_CREATE = "rest.suffix.create";
    private static final String PROP_REST_UPDATE = "rest.suffix.update";
    private static final String PROP_REST_DELETE = "rest.suffix.delete";

    @Autowired
    private Environment env;

    @Autowired
    protected RestTemplate restTemplate;

    private final Class<T> clazz;
    private final Class<L> listClazz;

    private final String entityName;

    public CommonServiceImpl(String entityName) {
        this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.listClazz = (Class<L>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.entityName = entityName;
    }

/*
    public CommonServiceImpl(RestTemplate restTemplate, Environment env, String entityName) {
        this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.listClazz = (Class<L>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Assert.notNull(env, "Environment must not be null!");
        this.env = env;
        Assert.notNull(restTemplate, "RestTemplate must not be null!");
        this.restTemplate = restTemplate;
        this.entityName = entityName;
    }
*/

    protected String getPath(String suffix) {
        return String.format(env.getProperty(PROP_REST_PATH) + env.getProperty(suffix), entityName);
    }

    public T getById(Integer id) {
        return restTemplate.getForObject(getPath(PROP_REST_GET_BY_ID), clazz, id);
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
        CommonEntityList<T> list = restTemplate.getForObject(getPath(PROP_REST_GET_ALL), listClazz);
        return list.getEntities();
    }

    public CommonEntityList<T> getPage(Integer page, Integer size) {
        return restTemplate.getForObject(getPath(PROP_REST_GET_PAGE), listClazz, page, size);
    }
}
