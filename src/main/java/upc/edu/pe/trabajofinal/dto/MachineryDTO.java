package upc.edu.pe.trabajofinal.dto;



import upc.edu.pe.trabajofinal.model.Mine;

import java.time.LocalDate;

public class MachineryDTO {
    private Integer id_machinery;
    private String name;
    private String manufacturer;
    private String model;
    private String serial_number;
    private LocalDate purchase_date;
    private String operational_stat;
    private Mine mine;

    public Integer getId_machinery() {
        return id_machinery;
    }

    public void setId_machinery(Integer id_machinery) {
        this.id_machinery = id_machinery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getOperational_stat() {
        return operational_stat;
    }

    public void setOperational_stat(String operational_stat) {
        this.operational_stat = operational_stat;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }
}
