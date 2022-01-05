package IG.test.repository;


import IG.test.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

}
