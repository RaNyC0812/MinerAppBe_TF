package upc.edu.pe.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name = "mineralType")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Mineral_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mineralType;
    private String type;
    private String general_propertie;

    @OneToOne
    @JoinColumn(name = "mineral_id")
    private Mineral mineral;

    public Integer getId_mineralType() {
        return id_mineralType;
    }

    public void setId_mineralType(Integer id_mineralType) {
        this.id_mineralType = id_mineralType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeneral_propertie() {
        return general_propertie;
    }

    public void setGeneral_propertie(String general_propertie) {
        this.general_propertie = general_propertie;
    }

    public Mineral getMineral() {
        return mineral;
    }

    public void setMineral(Mineral mineral) {
        this.mineral = mineral;
    }

    public Mineral_type() {
    }

    public Mineral_type(Integer id_mineralType, String type, String general_propertie, Mineral mineral) {
        this.id_mineralType = id_mineralType;
        this.type = type;
        this.general_propertie = general_propertie;
        this.mineral = mineral;
    }
}
