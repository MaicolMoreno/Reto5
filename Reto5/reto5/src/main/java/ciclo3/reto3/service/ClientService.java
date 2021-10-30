package ciclo3.reto3.service;

import ciclo3.reto3.model.Client;
import ciclo3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author MaicolMoreno
 */
@Service
public class ClientService {
     @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int idClient) {
        return clientRepository.getClient(idClient);
    }
    
    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> tmpClient = clientRepository.getClient(client.getIdClient());
            if (tmpClient.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
    
     public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> tmpClient = clientRepository.getClient(client.getIdClient());
            if (!tmpClient.isEmpty()) {
                return clientRepository.save(client);
            }
        }
        return client;
    }
     
      public boolean deleteClient(int id) {
        Boolean result = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return result;
    }
}
