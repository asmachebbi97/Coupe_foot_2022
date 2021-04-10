package Qatar.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	//@GetMapping("/match_equipes")
	@RequestMapping(value="/match_equipes", method = RequestMethod.GET)
	public List<MatchEquipe> getAllMatchEquipe() {
		List<MatchEquipe> eq = matchequipeR.findAll();

	
        return eq;
	    }
	


	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	//@GetMapping("/Match_Equipe/{eid}")
	@RequestMapping(value="/Match_Equipe/{eid}", method = RequestMethod.GET)
	public MatchEquipe getMatchEquipeById(@PathVariable(value = "eid") Long eId) {
	
	return  matchequipeR.findById(eId).orElseThrow(null);
	           
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	//@DeleteMapping("/MatchEquipe/{mid}")
	@RequestMapping(value="/MatchEquipe/{mid}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMatchEquipe(@PathVariable(value = "mid") Long mId) {
	
		MatchEquipe me =(matchequipeR).findById(mId).orElseThrow(null);
	          
		(matchequipeR).delete(me);

	    return ResponseEntity.ok().build();
	}
	

	 @PreAuthorize("hasRole('ADMIN')")
	//@PostMapping("/addMatchEquipe/{eid}/{mid}")
	 @RequestMapping(value="/addMatchEquipe/{eid}/{mid}", method = RequestMethod.POST)
	public MatchEquipe createMatchEquipe(@PathVariable(value = "eid") Long Id,
			@PathVariable(value = "mid") Long Idm, @Valid @RequestBody MatchEquipe matchEquipeDetails) {

	    
	       MatchEquipe me=new MatchEquipe();
		   Equibe equipe = equipeR.findById(Id).orElseThrow(null);
		   Matche match=matchR.findById(Idm).orElseThrow(null);
	
		   
		      me.setMatch(match);
			  me.setEquipe(equipe);
		      me.setNbbut(matchEquipeDetails.getNbbut());

		  //User affecterUser= 
		   return matchequipeR.save(me);
		//return affecterUser;
	

	}
	 @PreAuthorize("hasRole('ADMIN')")
	//@PutMapping("/affecterMatchEquipe/{meid}/{eid}/{mid}")
	 @RequestMapping(value="/affecterMatchEquipe/{meid}/{eid}/{mid}", method = RequestMethod.PUT)
	public MatchEquipe  affecterMatchEquipe(@PathVariable(value = "meid") Long meId,
			@PathVariable(value = "eid") Long Id,
			@PathVariable(value = "mid") Long Idm, @Valid @RequestBody MatchEquipe matchEquipeDetails) {

	    
	   MatchEquipe me =matchequipeR.findById(meId).orElseThrow(null);
	   Equibe equipe = equipeR.findById(Id).get();
	   Matche match=matchR.findById(Idm).get();

	   
	      me.setMatch(match);
		  me.setEquipe(equipe);
	      me.setNbbut(matchEquipeDetails.getNbbut());

	  //User affecterUser= 
	   return matchequipeR.save(me);

	}
	/*@PostMapping("/addMatchEquipe")
	public MatchEquipe createMatchEquipe(@Valid @RequestBody MatchEquipe me) {
	    return matchequipeR.save(me);
	}*/
	
	/*@PutMapping("/affecterMatchEquipe/{mid}")
	public MatchEquipe  affecterMatchEquipe(@PathVariable(value = "mid") Long mId,
			@Valid @RequestBody MatchEquipe matchEquipeDetails) 
	{
		
	    
		MatchEquipe me =matchequipeR.findById(mId).orElseThrow(null);
		
	   
		  
		  
	  me.setMatch(matchEquipeDetails.getMatch());
	  me.setEquipe(matchEquipeDetails.getEquipe());
       me.setNbbut(matchEquipeDetails.getNbbut());

       MatchEquipe updatedMatchEquipe = matchequipeR.save(me);
       
	    return updatedMatchEquipe;

	}*/
}
