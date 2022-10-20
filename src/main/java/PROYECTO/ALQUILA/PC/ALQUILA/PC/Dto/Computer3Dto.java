package PROYECTO.ALQUILA.PC.ALQUILA.PC.Dto;


import java.util.List;

public class Computer3Dto {
    private int id;

    private String name;
    private String brand;
    private String year;
    private String description;

    private CategoryDto category;

    List<Message2Dto> messages;



    public Computer3Dto() {
    }

    public Computer3Dto(int id, String name, String brand, String year, String description, CategoryDto category, List<Message2Dto> messages) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.category = category;
        this.messages = messages;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public List<Message2Dto> getMessages() {
        return messages;
    }

    public void setMessages(List<Message2Dto> messages) {
        this.messages = messages;
    }
}

