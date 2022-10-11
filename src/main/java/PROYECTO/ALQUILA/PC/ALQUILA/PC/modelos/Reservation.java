package PROYECTO.ALQUILA.PC.ALQUILA.PC.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
@Table(name = "reservation")

public class Reservation implements Serializable {
    @Id
    private Integer id_reservation;
    private DateTimeFormat devolution_date;
    private DateTimeFormat star_date;
    private Integer status;

    /**
     *
     * @param id_reservation
     * @param devolution_date
     * @param star_date
     * @param status
     */
    public Reservation(
            Integer id_reservation,DateTimeFormat devolution_date,DateTimeFormat star_date,Integer status){
        this.setId_reservation(id_reservation);
        this.setDevolution_date(devolution_date);
        this.setStar_date(star_date);
        this.setStatus(status);
    }

    public Integer getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Integer id_reservation) {
        this.id_reservation = id_reservation;
    }

    public DateTimeFormat getDevolution_date() {
        return devolution_date;
    }

    public void setDevolution_date(DateTimeFormat devolution_date) {
        this.devolution_date = devolution_date;
    }

    public DateTimeFormat getStar_date() {
        return star_date;
    }

    public void setStar_date(DateTimeFormat star_date) {
        this.star_date = star_date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
