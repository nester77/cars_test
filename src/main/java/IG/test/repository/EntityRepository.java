package IG.test.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

public interface EntityRepository<T, Long> extends PagingAndSortingRepository <T,Long> {
}
