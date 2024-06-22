package upc.edu.pe.trabajofinal.dto;
import upc.edu.pe.trabajofinal.model.Employee;

public class Employee_typeDTO{

    private Integer employee_type_id;
    private String type;
    private String descripcion;
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
}
