package ciclo3.reto3.crudrepository;

import ciclo3.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author MaicolMoreno
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
