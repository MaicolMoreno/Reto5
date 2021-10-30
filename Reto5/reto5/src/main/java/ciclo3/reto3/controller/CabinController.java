package ciclo3.reto3.controller;

import ciclo3.reto3.model.Cabin;
import ciclo3.reto3.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*; 

import java.util.List;
import java.util.Optional;
/**
 *
 * @author MaicolMoreno
 */
@RestController
@RequestMapping("/api/Cabin")
public class CabinController {
    @Autowired
    private CabinService cabinService;
    
    @GetMapping("/all")
    public List<Cabin> getAll() {
        return cabinService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int id) {
        return cabinService.getCabin(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {
        return cabinService.save(cabin);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return cabinService.update(cabin);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return cabinService.deleteCabin(id);
    }   
    
}
      