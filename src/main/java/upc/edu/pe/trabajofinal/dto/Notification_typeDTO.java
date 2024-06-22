package upc.edu.pe.trabajofinal.dto;
import upc.edu.pe.trabajofinal.model.Notification;

public class Notification_typeDTO {
    private Integer id_notiType;
    private String severityLevel;
    private Notification notification;

    public Integer getId_notiType() {
        return id_notiType;
    }

    public void setId_notiType(Integer id_notiType) {
        this.id_notiType = id_notiType;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
