package upc.edu.pe.trabajofinal.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_maintenance;
    private LocalDate maintenance_date;
    private String performed_by;
    private String description;
    private String maintenance_type;
    private BigDecimal cost;
    private LocalDate next_maintenance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_machina")

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

    public Maintenance() {
    }

    public Maintenance(Integer id_maintenance, LocalDate maintenance_date, String performed_by, String description, String maintenance_type, BigDecimal cost, LocalDate next_maintenance, Machinery machinery) {
        this.id_maintenance = id_maintenance;
        this.maintenance_date = maintenance_date;
        this.performed_by = performed_by;
        this.description = description;
        this.maintenance_type = maintenance_type;
        this.cost = cost;
        this.next_maintenance = next_maintenance;
        this.machinery = machinery;
    }


}
