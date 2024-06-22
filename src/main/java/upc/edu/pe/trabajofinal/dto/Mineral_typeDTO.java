package upc.edu.pe.trabajofinal.dto;



import upc.edu.pe.trabajofinal.model.Mineral;

public class Mineral_typeDTO {
    private Integer id_mineralType;
    private String type;
    private String general_propertie;
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
}
