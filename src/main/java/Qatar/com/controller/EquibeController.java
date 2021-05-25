package Qatar.com.controller;
import java.util.ArrayList;
import java.util.List;
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

import Qatar.com.controller.EquibeController;
import Qatar.com.entities.Equibe;
import Qatar.com.entities.TypePool;
//import Qatar.com.entities.Match;
import Qatar.com.repository.equibeRepository;
//import Qatar.com.repository.matchRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api") 
public class EquibeController {
	
	private static final Logger logger = LogManager.getLogger(AuthController.class);
	@Autowired 
	equibeRepository equiberepo;
	

	@RequestMapping(value="/EquibesA", method = RequestMethod.GET)
	public List<Equibe> getEquipegroupeA() {
		List<Equibe> pro = equiberepo.findAll();
		List<Equibe> GA =new ArrayList<Equibe>();
        for(int i=0;i<pro.size();i++)
        {
        	if(pro.get(i).getPool()==TypePool.A)
        	{
        		GA.add(pro.get(i));
        	}
        }

        return GA;
	    
	}
	
	@RequestMapping(value="/EquibesB", method = RequestMethod.GET)
	public List<Equibe> getEquipegroupeB() {
		List<Equibe> pro = equiberepo.findAll();
		List<Equibe> GA =new ArrayList<Equibe>();
        for(int i=0;i<pro.size();i++)
        {
        	if(pro.get(i).getPool()==TypePool.B)
        	{
        		GA.add(pro.get(i));
        	}
        }

        return GA;
	    
	}
	@RequestMapping(value="/EquibesC", method = RequestMethod.GET)
	public List<Equibe> getEquipegroupeC() {
		List<Equibe> pro = equiberepo.findAll();
		List<Equibe> GA =new ArrayList<Equibe>();
        for(int i=0;i<pro.size();i++)
        {
        	if(pro.get(i).getPool()==TypePool.C)
        	{
        		GA.add(pro.get(i));
        	}
        }

        return GA;
	    
	}
	@RequestMapping(value="/EquibesD", method = RequestMethod.GET)
	public List<Equibe> getEquipegroupeD() {
		List<Equibe> pro = equiberepo.findAll();
		List<Equibe> GA =new ArrayList<Equibe>();
        for(int i=0;i<pro.size();i++)
        {
        	if(pro.get(i).getPool()==TypePool.D)
        	{
        		GA.add(pro.get(i));
        	}
        }

        return GA;
	    
	}
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	//@GetMapping("/Equibes")
	@RequestMapping(value="/Equibes", method = RequestMethod.GET)
	public List<Equibe> getAllEquibe() {
		List<Equibe> pro = equiberepo.findAll();


        return pro;
	    
	}
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	//@GetMapping("/Equibe/{id}")
	@RequestMapping(value="/Equibe/{id}", method = RequestMethod.GET)

	public Equibe getEquibeById(@PathVariable(value = "id") Long Id) {
	    return equiberepo.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	//@PostMapping("/addEquibe")
	@RequestMapping(value="/addEquibe", method = RequestMethod.POST)

	public Equibe createEquibe(@Valid @RequestBody Equibe equibe) {
	    return equiberepo.save(equibe); 
	}
	
	
	//@PreAuthorize("hasRole('ADMIN')")
	//@PutMapping("/UpdateEquibe/{id}")
	@RequestMapping(value="/UpdateEquibe/{id}", method = RequestMethod.PUT)
	public Equibe updateEquibe(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Equibe EquibeDetails) {

		Equibe equibe = equiberepo.findById(Id).orElseThrow(null);
	    
	   
		equibe.setNomEquipe(EquibeDetails.getNomEquipe());
		equibe.setPays(EquibeDetails.getPays());
		equibe.setNbrePoint(EquibeDetails.getNbrePoint());
		equibe.setRang(EquibeDetails.getRang());
		equibe.setNbreJoueur(EquibeDetails.getNbrePoint());
		equibe.setImageequipe(EquibeDetails.getImageequipe());
		equibe.setNbMatchJoues(EquibeDetails.getNbMatchJoues());
		equibe.setNbPertes(EquibeDetails.getNbPertes());
		equibe.setNbVictoires(EquibeDetails.getNbVictoires());
		equibe.setNbEgalites(EquibeDetails.getNbEgalites());
		equibe.setPool(EquibeDetails.getPool());
		Equibe updatedEquibe = equiberepo.save(equibe);
	    return updatedEquibe;
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	//@DeleteMapping("/equibe/{id}")
	@RequestMapping(value="/equibe/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEquibe(@PathVariable(value = "id") Long equibeId) {
	    Equibe equibe = (equiberepo).findById(equibeId).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	   ( equiberepo).delete(equibe);

	    return ResponseEntity.ok().build();
	}
	
	
	//@PutMapping("/ListeMatch/{aid}/{pid}")
	//public Match GetListeMatchByEquibe(@PathVariable( "id") Long Id) {

	    
	   
  //      return  matchRepo.findById(Id).get();
//
		   
		
//	}
	
	
	/*@PutMapping("/affecter/{uid1}/{uid2}/{pid}")
	public void affecterEquibeMatch(@PathVariable(value = "uid1") Long Id1,@PathVariable(value = "uid2") Long Id2,
			@PathVariable(value = "pid") Long Idp,@Valid  Match match) {

	    
		 List<Equibe> list=new ArrayList<>();
		   Equibe equibe1 = equiberepo.findById(Id1).get();
		   Equibe equibe2 = equiberepo.findById(Id2).get();
		   Match ma=matchRepo.findById(Idp).get();
		   list.add(equibe1);
		   list.add(equibe1);
		   ma.setEquibe1((Set<Equibe>) equibe1);
		   ma.setEquibe2((Set<Equibe>) equibe2);
		  //User affecterUser= 
		   matchRepo.save(ma);
		//return affecterUser;
	

	}
*/

}
