package ciclo3.reto3.repository;

import ciclo3.reto3.crudrepository.ReservationCrudRepository;
import ciclo3.reto3.model.Client;
import ciclo3.reto3.model.Reservation;
import ciclo3.reto3.reportes.ContadorClientes;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author MaicolMoreno
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation) {
        reservationCrudRepository.delete(reservation);
    }    
     
     public List<Reservation> ReservacionStatusRepositorio (String status){
         return reservationCrudRepository.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }
}
