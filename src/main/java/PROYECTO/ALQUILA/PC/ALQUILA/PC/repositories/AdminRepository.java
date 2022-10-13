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

    /**
     *
     * @return
     */
    public List<Admin> getAll(){
        return (List<Admin>) adminCRUDRepository.findAll();

    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Admin> getAdmin(int id){
        return adminCRUDRepository.findById(id);


    }

    /**
     *
     * @param admin
     * @return
     */
    public Admin save(Admin admin){
        return adminCRUDRepository.save(admin);


    }

    /**
     *
     * @param admin
     */
    public void delete(Admin admin){
        adminCRUDRepository.delete(admin);

    }

}
