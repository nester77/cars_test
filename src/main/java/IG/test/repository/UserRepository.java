package IG.test.repository;


import IG.test.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<User, Long>, EntityRepository<User, Long> {
    User findByUsername(String username);



}
