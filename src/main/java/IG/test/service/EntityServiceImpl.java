package IG.test.service;

import IG.test.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityServiceImpl<T> implements EntityService {
    @Autowired
    private EntityRepository entityRepository;

    @Override
    public List<T> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<T> pagedResult = entityRepository.findAll(paging);
        return pagedResult.toList();
    }
}
