package Qatar.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Qatar.com.repository.MatchRepository;

import Qatar.com.entities.Matche;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@Controller

public class MatcheController {
	@Autowired 
	MatchRepository Matche;
	@GetMapping("/Matche")
	public List<Matche> getAllMatche() {
		List<Matche> mat = Matche.findAll();

        return mat;
	    				
	}
	@PostMapping("/addMatche")
	public Matche createMatch(@Valid @RequestBody Matche mat) {
	    return Matche.save(mat);
	}
	@GetMapping("/Matche/{id}")
	public Matche getUserById(@PathVariable(value = "id") Long Id) {
	    return Matche.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	@PutMapping("/Match/{id}")
	public Matche updateMatch(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Matche MatcheDetails) {

	    Matche mat = Matche.findById(Id).orElseThrow(null);
	    
	   
	    mat.setNom(MatcheDetails.getNom());
	    mat.setDate(MatcheDetails.getDate());
	    mat.setLieu(MatcheDetails.getLieu());
	    mat.setHeure(MatcheDetails.getHeure());
	    mat.setStade(MatcheDetails.getStade());
	    mat.setIdequipe1(MatcheDetails.getIdequipe1());
	    mat.setIdequipe2(MatcheDetails.getIdequipe2());
	    mat.setIdarbitre(MatcheDetails.getIdarbitre());
	    

	    Matche updatedMatch = Matche.save(mat);
	    return updatedMatch;
	}
	@PutMapping("/affecter/{uid}/{pid}")
	public void affecterMatch(@PathVariable(value = "uid") Long Id,
			@PathVariable(value = "pid") Long Idp) {

	    
	   List<Matche> list=new ArrayList<>();
		   Matche mat = Matche.findById(Id).get();
		   list.add(mat);
		   
}
	@DeleteMapping("/Matche/{id}")
	public ResponseEntity<?> deleteMatche(@PathVariable(value = "id") Long MatcheId) {
	    Matche mat = Matche.findById(MatcheId).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    Matche.delete(mat);

	    return ResponseEntity.ok().build();
	}
	}
