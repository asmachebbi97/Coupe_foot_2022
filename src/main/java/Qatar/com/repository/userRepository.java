package Qatar.com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import Qatar.com.entities.User;

@Repository
public interface userRepository extends JpaRepository<User,Long> {

}
