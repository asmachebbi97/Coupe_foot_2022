package Qatar.com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Qatar.com.entities.User;


@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

