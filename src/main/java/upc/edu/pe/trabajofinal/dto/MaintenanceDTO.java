package upc.edu.pe.trabajofinal.dto;

import upc.edu.pe.trabajofinal.model.Machinery;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MaintenanceDTO {
    private Integer id_maintenance;
    private LocalDate maintenance_date;
    private String performed_by;
    private String description;
    private String maintenance_type;
    private BigDecimal cost;
    private LocalDate next_maintenance;
    private Machinery machinery;

    public Integer getId_maintenance() {
        return id_maintenance;
    }

    public void setId_maintenance(Integer id_maintenance) {
        this.id_maintenance = id_maintenance;
    }

    public LocalDate getMaintenance_date() {
        return maintenance_date;
    }

    public void setMaintenance_date(LocalDate maintenance_date) {
        this.maintenance_date = maintenance_date;
    }

    public String getPerformed_by() {
        return performed_by;
    }

    public void setPerformed_by(String performed_by) {
        this.performed_by = performed_by;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaintenance_type() {
        return maintenance_type;
    }

    public void setMaintenance_type(String maintenance_type) {
        this.maintenance_type = maintenance_type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDate getNext_maintenance() {
        return next_maintenance;
    }

    public void setNext_maintenance(LocalDate next_maintenance) {
        this.next_maintenance = next_maintenance;
    }

    public Machinery getMachinery() {
        return machinery;
    }

    public void setMachinery(Machinery machinery) {
        this.machinery = machinery;
    }
}
