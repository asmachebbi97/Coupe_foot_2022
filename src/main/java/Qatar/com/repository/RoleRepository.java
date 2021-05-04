package Qatar.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Qatar.com.entities.ERole;
import Qatar.com.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	Optional<Role> findByName(ERole name);
}
