package by.pvt.module4.common;

import org.springframework.data.repository.CrudRepository;

public interface CommonRepository<T extends Fact> extends CrudRepository<T, Integer> {
}
