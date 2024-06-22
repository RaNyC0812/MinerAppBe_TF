package upc.edu.pe.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "notification")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_notification;
    private LocalDate dateTimeReceived;
    private String location;
    private String descripcion;
    private String actionTaken;
    private String responsiblePerson;
    private String currentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_id")
    private Mine mine;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Integer getId_notification() {
        return id_notification;
    }

    public void setId_notification(Integer id_notification) {
        this.id_notification = id_notification;
    }

    public LocalDate getDateTimeReceived() {
        return dateTimeReceived;
    }

    public void setDateTimeReceived(LocalDate dateTimeReceived) {
        this.dateTimeReceived = dateTimeReceived;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Notification() {
    }

    public Notification(Integer id_notification, LocalDate dateTimeReceived, String location, String descripcion, String actionTaken, String responsiblePerson, String currentStatus, Mine mine, Employee employee) {
        this.id_notification = id_notification;
        this.dateTimeReceived = dateTimeReceived;
        this.location = location;
        this.descripcion = descripcion;
        this.actionTaken = actionTaken;
        this.responsiblePerson = responsiblePerson;
        this.currentStatus = currentStatus;
        this.mine = mine;
        this.employee = employee;
    }
}
