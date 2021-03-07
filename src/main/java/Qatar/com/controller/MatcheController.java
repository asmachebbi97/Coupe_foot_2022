package Qatar.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Qatar.com.repository.MatchRepository;
import Qatar.com.entities.Equibe;
import Qatar.com.entities.Matche;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MatcheController {
	@Autowired 
	MatchRepository MatchR;
	@GetMapping("/Matche")
	public List<Matche> getAllMatche() {
		List<Matche> mat = MatchR.findAll();

        return mat;
	    				
	}
	@PostMapping("/addMatche")
	public Matche createMatch(@Valid @RequestBody Matche mat) {
	    return MatchR.save(mat);
	}
	@GetMapping("/Matche/{id}")
	public Matche getMatchById(@PathVariable(value = "id") Long Id) {
	    return MatchR.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	@PutMapping("/Match/{id}")
	public Matche updateMatch(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Matche MatcheDetails) {

	    Matche mat = MatchR.findById(Id).orElseThrow(null);
	    
	   
	    mat.setNom(MatcheDetails.getNom());
	    mat.setDate(MatcheDetails.getDate());
	    mat.setLieu(MatcheDetails.getLieu());
	    mat.setHeure(MatcheDetails.getHeure());
	    mat.setStade(MatcheDetails.getStade());

	    Matche updatedMatch = MatchR.save(mat);
	    return updatedMatch;
	}
	
	
	
	
	@DeleteMapping("/Matche/{id}")
	public ResponseEntity<?> deleteMatche(@PathVariable(value = "id") Long MatcheId) {
	    Matche mat = MatchR.findById(MatcheId).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    MatchR.delete(mat);

	    return ResponseEntity.ok().build();
	}
	}
