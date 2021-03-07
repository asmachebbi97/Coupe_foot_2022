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

import Qatar.com.entities.Arbitre;
import Qatar.com.repository.arbitreRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class ArbitreController {
	private static final Logger logger = LogManager.getLogger(ArbitreController.class);
	@Autowired
	arbitreRepository arbitrev;
	@GetMapping("/arbitres")
	public List<Arbitre> getAllArbitres() {
		List<Arbitre> pro = arbitrev.findAll();

		for (Arbitre arbitre : pro) {
			logger.debug("log:     "+arbitre);
			System.out.println("sysout:   "+arbitre);
			
		}
        return pro;
	    
	}

	@PostMapping("/addarbitre")
	public Arbitre createArbitre(@Valid @RequestBody Arbitre arbitre) {
	    return  arbitrev.save(arbitre);
	}

	
	@GetMapping("/arbitre/{id}")
	public Arbitre getArbitreById(@PathVariable(value = "id") Long Id) {
	    return arbitrev.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	@DeleteMapping("/arbitre/{id}")
	public ResponseEntity<?> deleteArbitre(@PathVariable(value = "id") Long arbitreId) {
	    Arbitre arbitre = ( arbitrev).findById(arbitreId).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    ( arbitrev).delete(arbitre);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/arbitre/{id}")
	public Arbitre updateArbitre(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Arbitre arbitreDetails) {
	    Arbitre arbitre=  arbitrev.findById(Id).orElseThrow(null);
	    
	   
	    arbitre.setNom(arbitreDetails.getNom());
	    arbitre.setRole(arbitreDetails.getRole());
	    arbitre.setImageArbitre(arbitreDetails.getImageArbitre());
	    arbitre.setSalaire(arbitreDetails.getSalaire());
	   

	    Arbitre updatedArbitre = arbitrev.save(arbitre);
	    return updatedArbitre;
	}
	
	


		
	

	

}
