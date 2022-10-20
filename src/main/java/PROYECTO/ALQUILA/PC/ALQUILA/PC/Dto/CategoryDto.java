package PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto;
import PROYECTO.ALQUILA.PC.ALQUILA.PC.models.ComputerEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryDto {
    private int id;

    private String name;
    private String description;


    public CategoryDto() {
    }


    public CategoryDto(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
