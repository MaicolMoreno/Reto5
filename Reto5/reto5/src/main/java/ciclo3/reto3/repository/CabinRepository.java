package ciclo3.reto3.repository;

import ciclo3.reto3.crudrepository.CabinCrudRepository;
import ciclo3.reto3.model.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author MaicolMoreno
 */
@Repository
public class CabinRepository {
    @Autowired
    private CabinCrudRepository cabinCrudRepository;
    
    public List<Cabin> getAll(){
        return (List<Cabin>) cabinCrudRepository.findAll();
    }
    
    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }
    
    public Cabin save(Cabin cabin){
        return cabinCrudRepository.save(cabin);
    }
    
    public void delete(Cabin cabin){
        cabinCrudRepository.delete(cabin);
    }
    
    
    
}
