package upc.edu.pe.trabajofinal.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;



@Entity
@Table(name = "employeeType")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Employee_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_type_id;
    private String type;
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    public Integer getEmployee_type_id() {
        return employee_type_id;
    }

    public void setEmployee_type_id(Integer employee_type_id) {
        this.employee_type_id = employee_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee_type() {
    }

    public Employee_type(Integer employee_type_id, String type, String descripcion, Employee employee) {
        this.employee_type_id = employee_type_id;
        this.type = type;
        this.descripcion = descripcion;
        this.employee = employee;
    }

}
