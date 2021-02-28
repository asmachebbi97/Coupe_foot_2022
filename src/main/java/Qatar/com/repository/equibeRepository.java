package Qatar.com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Qatar.com.entities.Equibe;
@Repository
public interface equibeRepository extends JpaRepository<Equibe,Long> {

}
