package PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories;


import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Message;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;

    /**
     *
     * @return
     */
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCRUDRepository.findAll();

    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Reservation> getClient(int id){
        return reservationCRUDRepository.findById(id);
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation save (Reservation reservation){
        return reservationCRUDRepository.save(reservation);
    }

    /**
     *
     * @param reservation
     */
    public void delete(Reservation reservation){
        reservationCRUDRepository.delete(reservation);

    }
}
