package Qatar.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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

import Qatar.com.entities.Equibe;
import Qatar.com.entities.MatchEquipe;

import Qatar.com.entities.Matche;
import Qatar.com.repository.MatchEquipeRepository;
import Qatar.com.repository.MatchRepository;
import Qatar.com.repository.equibeRepository;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class MatchEquipeController {
	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	MatchEquipeRepository matchequipeR;
	
	@Autowired
	equibeRepository equipeR;
	
	@Autowired
	MatchRepository matchR;

	
	
	@GetMapping("/match_equipes")
	public List<MatchEquipe> getAllMatchEquipe() {
		List<MatchEquipe> eq = matchequipeR.findAll();

		for (MatchEquipe me : eq) {
			logger.debug("log:     "+me);
			System.out.println("sysout:   "+me);
			
		}
        return eq;
	    }
	
	
	
	@PostMapping("/addMatchEquipe")
	public MatchEquipe createMatchEquipe(@Valid @RequestBody MatchEquipe me) {
	    return matchequipeR.save(me);
	}

	
	@GetMapping("/Match_Equipe/{eid}")
	public MatchEquipe getUserById(@PathVariable(value = "eid") Long eId) {
	
	return  matchequipeR.findById(eId).orElseThrow(null);
	           
	}
	
	
	@DeleteMapping("/MatchEquipe/{mid}")
	public ResponseEntity<?> deleteMatchEquipe(@PathVariable(value = "mid") Long mId) {
	
		MatchEquipe me =matchequipeR.findById(mId).orElseThrow(null);
	          
		matchequipeR.delete(me);

	    return ResponseEntity.ok().build();
	}
	

	@PutMapping("/affecterMatchEquipe/{mid}")
	public MatchEquipe  affecterMatchEquipe(@PathVariable(value = "mid") Long mId,
			@Valid @RequestBody MatchEquipe matchEquipeDetails) 
	{
		
	    
		MatchEquipe me =matchequipeR.findById(mId).orElseThrow(null);
		
	   
		  
		  
	  me.setMatch(matchEquipeDetails.getMatch());
	  me.setEquipe(matchEquipeDetails.getEquipe());
       me.setNbbut(matchEquipeDetails.getNbbut());

       MatchEquipe updatedMatchEquipe = matchequipeR.save(me);
       
	    return updatedMatchEquipe;

	}
	

}
