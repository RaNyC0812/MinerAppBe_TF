package upc.edu.pe.trabajofinal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.trabajofinal.model.Mine;

import upc.edu.pe.trabajofinal.model.Mineral;
import upc.edu.pe.trabajofinal.model.Notification;
import upc.edu.pe.trabajofinal.repository.NotificationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository dR;

    //Insertar
    public void insert(Notification notification) {
        dR.save(notification);
    }
    //Listar
    public List<Notification> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Notification listId(int id) {
        return dR.findById(id).orElse(new Notification());
    }
    public List<Object[]> getNotificationCountByMine() {
        return dR.countNotificationsByMine();
    }
    public List<Notification> search(String estado) {

        return dR.findByCurrentStatus(estado);
    }
    public List<Notification> findNotificationsByDateRange(LocalDate startDate, LocalDate endDate) {
        return dR.findNotificationsByDateRange(startDate, endDate);
    }
    public List<Object[]> countNotificationsByEmployee() {
        return dR.countNotificationsByEmployee();
    }
    public List<Notification> findNotificationsByEmployee(String employeeName) {
        return dR.findNotificationsByEmployee(employeeName);
    }
    public List<Notification> findNotificationsByMine(String mineName) {
        return dR.findNotificationsByMine(mineName);
    }
}
