package IG.test.repository;


import IG.test.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")

public interface UserRepository extends PagingAndSortingRepository<User,Long>
{
    User findByUsername(String username);

    @Query("SELECT r.roles_id FROM t_user_roles where r.user_id=:id")
    long findRoleByUserId(long id);
}
