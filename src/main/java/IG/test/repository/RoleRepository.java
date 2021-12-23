package IG.test.repository;

import IG.test.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Long> {
}
