package upc.edu.pe.trabajofinal.dto;
import upc.edu.pe.trabajofinal.model.Machinery;

public class Machinery_typeDTO {
    private Integer id_machinery_type;
    private String machinery_type_name;
    private String description;
    private String general_uses;
    private Machinery machinery;

    public Integer getId_machinery_type() {
        return id_machinery_type;
    }

    public void setId_machinery_type(Integer id_machinery_type) {
        this.id_machinery_type = id_machinery_type;
    }

    public String getMachinery_type_name() {
        return machinery_type_name;
    }

    public void setMachinery_type_name(String machinery_type_name) {
        this.machinery_type_name = machinery_type_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGeneral_uses() {
        return general_uses;
    }

    public void setGeneral_uses(String general_uses) {
        this.general_uses = general_uses;
    }

    public Machinery getMachinery() {
        return machinery;
    }

    public void setMachinery(Machinery machinery) {
        this.machinery = machinery;
    }
}
