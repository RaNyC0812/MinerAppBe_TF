package upc.edu.pe.trabajofinal.dto;
import upc.edu.pe.trabajofinal.model.Employee;
import upc.edu.pe.trabajofinal.model.Mine;

import java.time.LocalDate;

public class NotificationDTO {
    private Integer id_notification;
    private LocalDate dateTimeReceived;
    private String location;
    private String descripcion;
    private String actionTaken;
    private String responsiblePerson;
    private String currentStatus;
    private Mine mine;
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
}
