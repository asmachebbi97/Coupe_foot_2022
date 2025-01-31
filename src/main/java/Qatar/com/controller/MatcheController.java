package Qatar.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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

import Qatar.com.repository.MatchRepository;
import Qatar.com.repository.arbitreRepository;
import Qatar.com.entities.Arbitre;
import Qatar.com.entities.Equibe;
import Qatar.com.entities.Matche;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MatcheController {
	@Autowired 
	MatchRepository MatchR;
	
	@Autowired 
	arbitreRepository ArbitreR;
	
	
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value="/Matche", method = RequestMethod.GET)
	public List<Matche> getAllMatche() {
		List<Matche> mat = MatchR.findAll();

        return mat;
	    				
	}
	// @PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/addMatche/{idA}", method = RequestMethod.POST)
	public Matche createMatch(@PathVariable(value = "idA") Long IdA , 
			@Valid @RequestBody Matche MatcheDetails) {
		Arbitre arbitre = ArbitreR.findById(IdA).orElseThrow(null);;
       Matche mat= new Matche();
	    
	    mat.setNom(MatcheDetails.getNom());
	    mat.setDate(MatcheDetails.getDate());
	    mat.setLieu(MatcheDetails.getLieu());
	    mat.setHeure(MatcheDetails.getHeure());
	    mat.setStade(MatcheDetails.getStade());
	    mat.setMk(arbitre);
	    

	    
	    
	    
	    return MatchR.save(mat);
	}
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value="/Matche/{id}", method = RequestMethod.GET)
	public Matche getMatchById(@PathVariable(value = "id") Long Id) {
	    return MatchR.findById(Id).orElseThrow(null);
	    
	    
	    
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/Match/{id}", method = RequestMethod.PUT)
	public Matche updateMatch(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Matche MatcheDetails) {
		
	    Matche mat = MatchR.findById(Id).orElseThrow(null);
	    
	   
	    mat.setNom(MatcheDetails.getNom());
	    mat.setDate(MatcheDetails.getDate());
	    mat.setLieu(MatcheDetails.getLieu());
	    mat.setHeure(MatcheDetails.getHeure());
	    mat.setStade(MatcheDetails.getStade());
	    mat.setMk(MatcheDetails.getMk());
	    

	    Matche updatedMatch = MatchR.save(mat);
	    return updatedMatch;
	}
	
	
	
	//@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/Matche/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMatche(@PathVariable(value = "id") Long MatcheId) {
	    Matche mat = MatchR.findById(MatcheId).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    MatchR.delete(mat);

	    return ResponseEntity.ok().build();
	}
	}
