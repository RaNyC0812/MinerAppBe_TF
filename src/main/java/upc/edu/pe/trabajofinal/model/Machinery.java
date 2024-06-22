package upc.edu.pe.trabajofinal.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "machinery")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Machinery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_machinery;
    private String name;
    private String manufacturer;
    private String model;
    private String serial_number;
    private LocalDate purchase_date;
    private String operational_stat;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_machinery_type")
    private Machinery_type machineryType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_id")
    private  Mine mine;

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

    public Machinery() {
    }

    public Machinery(Integer id_machinery, String name, String manufacturer, String model, String serial_number, LocalDate purchase_date, String operational_stat, Mine mine) {
        this.id_machinery = id_machinery;
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.serial_number = serial_number;
        this.purchase_date = purchase_date;
        this.operational_stat = operational_stat;
        this.mine = mine;
    }

}
