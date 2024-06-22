package upc.edu.pe.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "mine")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Mine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mine;
    private String name;
    private String location;

    public Mine(Integer id_mine, String name, String location) {
        this.id_mine = id_mine;
        this.name =name; //Nombre de la sede ser el name
        this.location = location;
    }

    public Mine() {
    }

    public Integer getId_mine() {
        return id_mine;
    }

    public void setId_mine(Integer id_mine) {
        this.id_mine = id_mine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
