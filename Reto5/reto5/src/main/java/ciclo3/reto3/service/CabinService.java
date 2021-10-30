package ciclo3.reto3.service;

import ciclo3.reto3.model.Cabin;
import ciclo3.reto3.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author MaicolMoreno
 */
@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll() {
        return cabinRepository.getAll();
    }

    public Optional<Cabin> getCabin(int id) {
        return cabinRepository.getCabin(id);
    }

    public Cabin save(Cabin cabin) {
        if (cabin.getId() == null) {
            return cabinRepository.save(cabin);
        } else {
            Optional<Cabin> tmpCabin = cabinRepository.getCabin(cabin.getId());
            if (tmpCabin.isEmpty()) {
                return cabinRepository.save(cabin);
            } else {
                return cabin;
            }
        }
    }

    public Cabin update(Cabin cabin) {
        if (cabin.getId() != null) {
            Optional<Cabin> tmpCabin = cabinRepository.getCabin(cabin.getId());
            if (!tmpCabin.isEmpty()) {
                if (cabin.getName() != null) {
                    tmpCabin.get().setName(cabin.getName());
                }
                if (cabin.getBrand() != null) {
                    tmpCabin.get().setBrand(cabin.getBrand());
                }
                if (cabin.getRooms() != null) {
                    tmpCabin.get().setRooms(cabin.getRooms());
                }
                if (cabin.getDescription()!= null) {
                    tmpCabin.get().setDescription(cabin.getDescription());
                }
                cabinRepository.save(tmpCabin.get());
                return tmpCabin.get();
            } else {
                return cabin;
            }
        } else {
            return cabin;
        }

    }

    public boolean deleteCabin(int id) {
        Boolean result = getCabin(id).map(cabin -> {
            cabinRepository.delete(cabin);
            return true;
        }).orElse(false);
        return result;
    }

}
