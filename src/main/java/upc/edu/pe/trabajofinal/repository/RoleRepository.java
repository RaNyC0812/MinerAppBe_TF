package upc.edu.pe.trabajofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
