package Qatar.com.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import Qatar.com.entities.MatchEquipe;

import Qatar.com.entities.User;

@Repository
public interface MatchEquipeRepository extends JpaRepository<MatchEquipe,Long> {

	
	
}
