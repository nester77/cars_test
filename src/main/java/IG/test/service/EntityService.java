package IG.test.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface EntityService<T> {
    List<T> findPaginated(int pageNo, int pageSize);
}
