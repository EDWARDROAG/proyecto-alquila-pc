package PROYECTO.ALQUILA.PC.ALQUILA.PC.services;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationService implements IReservationService {

    @Autowired
    ReservationRepository entityRepository;


    @Override
    public ReservationEntity add(ReservationEntity entity) {
        entityRepository.save(entity);
        return entity;

    }

    @Override
    public Optional<ReservationEntity> getById(Integer id) {
        return entityRepository.findById(id);
    }

    @Override
    public List<ReservationEntity> getList() {
        return (List<ReservationEntity>) entityRepository.findAll();
    }

    @Override
    public ReservationEntity update(ReservationEntity entity) {
        entityRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        entityRepository.deleteById(id);
    }

    @Override
    public List<ReservationEntity> getListByClient(Integer clientId) {
        return (List<ReservationEntity>) entityRepository.findByClientId(clientId);
    }
}
