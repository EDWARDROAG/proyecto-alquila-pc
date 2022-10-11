package PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public class AdminRepository {
    @Autowired
    private AdminCRUDRepository adminCRUDRepository;


    public List<Admin> getAll(){
        return (List<Admin>) adminCRUDRepository.findAll();

    }

    public Optional<Admin> getadmin(int code){
        return adminCRUDRepository.findById(code);


    }

    public Admin save(Admin admin){
        return adminCRUDRepository.save(admin);


    }

    public void delete(Admin admin){
        adminCRUDRepository.delete(admin);

    }

}
