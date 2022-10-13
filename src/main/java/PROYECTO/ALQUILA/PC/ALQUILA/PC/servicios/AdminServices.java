package PROYECTO.ALQUILA.PC.ALQUILA.PC.servicios;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos.Admin;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();


    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);

    }
    public Admin insertAdmin(Admin admin){
        if(admin.getId_admin() != null){
            Optional<Admin> temp = adminRepository.getAdmin(admin.getId_admin());
            if(temp.isEmpty())
                return adminRepository.save(admin);
            else
                return admin;
        }
        else
            return admin;
    }

    public Admin updateAdmin(Admin admin){
        if(admin.getId_admin() != null){
            Optional<Admin> temp = adminRepository.getAdmin(admin.getId_admin());
            if(!temp.isEmpty()){

                if(admin.getName() != null)
                    temp.get().setName(admin.getName());

                return adminRepository.save(temp.get());
                 }
             else
                return admin;
        }
        else
            return admin;

    }

    public Boolean deleteAdmin(int id_admin){
        Boolean succes = adminRepository.getAdmin(id_admin).map(admin ->{
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return succes;
    }
}
