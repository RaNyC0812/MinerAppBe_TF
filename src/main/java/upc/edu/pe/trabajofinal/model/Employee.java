package upc.edu.pe.trabajofinal.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column( name = "firstName", nullable = false, length = 100)
    private String firstName;

    @Column( name = "lastName", nullable = false, length = 100)
    private String lastName;

    @Column( name = "dateBirth", nullable = false)
    private LocalDate dateBirth;

    @Column( name = "gender", nullable = false, length = 100)
    private String gender;

    @Column( name = "hireDate", nullable = false)
    private LocalDate hireDate;

    @Column( name = "department", nullable = false, length = 100)
    private String department;

    @Column( name = "job_title", nullable = false, length = 100)
    private String job_title;

    @Column( name = "salary", nullable = false)
    private int salary;

    @Column( name = "contac_info", nullable = false, length = 100)
    private String contac_info;

    @Column( name = "address", nullable = false, length = 100)
    private String address;

    @Column( name = "emergency_contact", nullable = false, length = 100)
    private String emergency_contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_id")
    private Mine mine;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getContac_info() {
        return contac_info;
    }

    public void setContac_info(String contac_info) {
        this.contac_info = contac_info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public Employee() {
    }

    public Employee(Integer employeeId, String firstName, String lastName, LocalDate dateBirth, String gender, LocalDate hireDate, String department, String job_title, int salary, String contac_info, String address, String emergency_contact, Mine mine) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.hireDate = hireDate;
        this.department = department;
        this.job_title = job_title;
        this.salary = salary;
        this.contac_info = contac_info;
        this.address = address;
        this.emergency_contact = emergency_contact;
        this.mine = mine;
    }


}
