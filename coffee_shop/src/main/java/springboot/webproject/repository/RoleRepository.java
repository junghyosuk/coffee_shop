package springboot.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.webproject.dto.Role;


@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {


}