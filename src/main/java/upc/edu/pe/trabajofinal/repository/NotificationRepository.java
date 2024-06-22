package upc.edu.pe.trabajofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Machinery;
import upc.edu.pe.trabajofinal.model.Mineral;
import upc.edu.pe.trabajofinal.model.Notification;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    //Informe de notificaciones por mina
    @Query("SELECT n.mine.name, COUNT(n) FROM Notification n GROUP BY n.mine.name")
    List<Object[]> countNotificationsByMine();
    //Buscar por estado
    @Query("SELECT m FROM Notification m WHERE m.currentStatus LIKE %:currentStatus%")
    List<Notification> findByCurrentStatus(@Param("currentStatus") String currentStatus);
    //
    @Query("SELECT n FROM Notification n WHERE n.dateTimeReceived BETWEEN :startDate AND :endDate")
    List<Notification> findNotificationsByDateRange(LocalDate startDate, LocalDate endDate);

    //
    @Query("SELECT n.responsiblePerson, COUNT(n) FROM Notification n GROUP BY n.responsiblePerson")
    List<Object[]> countNotificationsByEmployee();
    @Query("SELECT n FROM Notification n WHERE n.responsiblePerson = :employeeName")
    List<Notification> findNotificationsByEmployee(String employeeName);


    @Query("SELECT n FROM Notification n WHERE n.mine.name = :mineName")
    List<Notification> findNotificationsByMine(String mineName);
}
