package Qatar.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Qatar.com.controller.UserController;
import Qatar.com.entities.User;
import Qatar.com.repository.userRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	userRepository userv;
	
	
	
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> pro = userv.findAll();

		for (User user : pro) {
			logger.debug("log:     "+user);
			System.out.println("sysout:   "+user);
			
		}
        return pro;
	    
	}

	@PostMapping("/addusert")
	public User createUser(@Valid @RequestBody User user) {
	    return userv.save(user);
	}

	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value = "id") Long Id) {
	    return userv.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    User user = userv.findById(userId).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    userv.delete(user);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody User userDetails) {

	    User user = userv.findById(Id).orElseThrow(null);
	    
	   
	    user.setEmail(userDetails.getEmail());
	    user.setPwd(userDetails.getPwd());
	    user.setFname(userDetails.getFname());
	    user.setLname(userDetails.getLname());
	    user.setImageuser(userDetails.getImageuser());
	    
	    User updatedUser = userv.save(user);
	    return updatedUser;
	}
	
	

	
	
	
	
	
	
}
