package upc.edu.pe.trabajofinal.dto;


import upc.edu.pe.trabajofinal.model.Mine;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MineralDTO {
    private Integer id_mineral;
    private String name;
    private String chemical_formul;
    private String color;
    private String hardness;
    private BigDecimal specific_gravity;
    private String crystal_system;
    private LocalDate fecha_extraccion;

    private Mine mine;

    public LocalDate getFecha_extraccion() {
        return fecha_extraccion;
    }

    public void setFecha_extraccion(LocalDate fecha_extraccion) {
        this.fecha_extraccion = fecha_extraccion;
    }

    public Integer getId_mineral() {
        return id_mineral;
    }

    public void setId_mineral(Integer id_mineral) {
        this.id_mineral = id_mineral;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChemical_formul() {
        return chemical_formul;
    }

    public void setChemical_formul(String chemical_formul) {
        this.chemical_formul = chemical_formul;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHardness() {
        return hardness;
    }

    public void setHardness(String hardness) {
        this.hardness = hardness;
    }

    public BigDecimal getSpecific_gravity() {
        return specific_gravity;
    }

    public void setSpecific_gravity(BigDecimal specific_gravity) {
        this.specific_gravity = specific_gravity;
    }

    public String getCrystal_system() {
        return crystal_system;
    }

    public void setCrystal_system(String crystal_system) {
        this.crystal_system = crystal_system;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }
}
