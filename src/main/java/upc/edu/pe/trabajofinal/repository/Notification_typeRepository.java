package upc.edu.pe.trabajofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Notification_type;

@Repository
public interface Notification_typeRepository extends JpaRepository<Notification_type, Integer> {
}
