package Qatar.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Qatar.com.entities.Arbitre;

@Repository
public interface arbitreRepository extends JpaRepository<Arbitre,Long> {

}
