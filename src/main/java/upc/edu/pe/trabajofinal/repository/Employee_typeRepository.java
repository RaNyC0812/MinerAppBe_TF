package upc.edu.pe.trabajofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Employee_type;

@Repository
public interface Employee_typeRepository extends JpaRepository<Employee_type,Integer> {
}
