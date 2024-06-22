package upc.edu.pe.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name = "notificationType")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Notification_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_notiType;
    private String severityLevel;

    @OneToOne
    @JoinColumn(name = "id_notification")
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

    public Notification_type() {
    }

    public Notification_type(Integer id_notiType, String severityLevel, Notification notification) {
        this.id_notiType = id_notiType;
        this.severityLevel = severityLevel;
        this.notification = notification;
    }
}
