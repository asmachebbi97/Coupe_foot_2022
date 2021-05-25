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

import Qatar.com.entities.Arbitre;
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
	private static final Logger logger = LogManager.getLogger(AuthController.class);
	@Autowired
	MatchEquipeRepository matchequipeR;
	
	@Autowired
	equibeRepository equipeR;
	
	@Autowired
	MatchRepository matchR;

	
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value="/match_equipes", method = RequestMethod.GET)
	public List<MatchEquipe> getAllMatchEquipe() {
		List<MatchEquipe> eq = matchequipeR.findAll();

	
        return eq;
	    }
	


	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value="/Match_Equipe/{eid}", method = RequestMethod.GET)
	public MatchEquipe getMatchEquipeById(@PathVariable(value = "eid") Long eId) {
	
	return  matchequipeR.findById(eId).orElseThrow(null);
	           
	}
	
   // @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/MatchEquipe/{mid}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMatchEquipe(@PathVariable(value = "mid") Long mId) {
	
		MatchEquipe me =(matchequipeR).findById(mId).orElseThrow(null);
	          
		(matchequipeR).delete(me);

	    return ResponseEntity.ok().build();
	}
	

	// @PreAuthorize("hasRole('ADMIN')")
	 @RequestMapping(value="/addMatchEquipe/{idEq1}/{idm}", method = RequestMethod.POST)
	public MatchEquipe createMatchEquipe(@PathVariable(value = "idEq1") Long idEq1,
			 @PathVariable(value = "idm") Long idm,
			@Valid @RequestBody MatchEquipe matchEquipeDetails) {

		 Equibe equipe1 = equipeR.findById(idEq1).orElseThrow(null);
		 
		 Matche match=matchR.findById(idm).orElseThrow(null);
		 
	       MatchEquipe match1=new MatchEquipe();
	      
	       
	
	       match1.setMatch(match);
	       match1.setEquipe(equipe1);
	       match1.setNbbut(matchEquipeDetails.getNbbut());
	       
	       
	       
	       
		   return matchequipeR.save(match1);
		
	

	}
	 //@PreAuthorize("hasRole('ADMIN')")
	 @RequestMapping(value="/affecterMatchEquipe/{meid}", method = RequestMethod.PUT)
	public MatchEquipe  affecterMatchEquipe(@PathVariable(value = "meid") Long meId,
			@Valid @RequestBody MatchEquipe matchEquipeDetails) {

	    
	   MatchEquipe me =matchequipeR.findById(meId).orElseThrow(null);
	   me.setEquipe(matchEquipeDetails.getEquipe());   
	   
	   me.setNbbut(matchEquipeDetails.getNbbut());
	      MatchEquipe updatedMatchEquipe = matchequipeR.save(me);

	  
	   return updatedMatchEquipe;

	}
	
}
