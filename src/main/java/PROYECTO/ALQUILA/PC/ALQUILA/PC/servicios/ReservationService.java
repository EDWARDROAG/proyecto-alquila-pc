package PROYECTO.ALQUILA.PC.ALQUILA.PC.servicios;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Client;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Reservation;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservation(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id_reservation){
        return  reservationRepository.getReservation(id_reservation);
    }

    public v insertReservation(Reservation reservation){

    }

    public Reservation updateReservation(Reservation reservation){

    }

    public Boolean deleteReservation(int id_reservation){
        Boolean success = reservationRepository.getReservation(id_reservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return success;

    }
}
