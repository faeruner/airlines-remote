package by.pvt.module4.common;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommonRepository<T extends Fact> extends PagingAndSortingRepository<T, Integer> {
}
