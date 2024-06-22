package upc.edu.pe.trabajofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Mine;

@Repository
public interface MineRepository extends JpaRepository<Mine,Integer> {
}
