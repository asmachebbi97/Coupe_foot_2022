package Qatar.com.service;

import java.util.List;

import Qatar.com.entities.User;
import Qatar.com.entities.UserDto;


public interface UserService {
	    User save(UserDto user);
	    List<User> findAll();
	    void delete(long id);
	    User findOne(String username);
	    User save(User user);
	    User findById(Long id);
	    
}
