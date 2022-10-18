package PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto;

import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.MessageEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ReservationEntity;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.RolEntity;

import java.util.ArrayList;
import java.util.List;


public class AdminDto {

    private int idAdmin;


    private String name;


    private String email;
    private Integer age;
    private String password;








    public AdminDto() {
    }

    public AdminDto(int idAdmin, String name, String email, Integer age, String password) {
        this.idAdmin = idAdmin;
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public AdminDto(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }




}
