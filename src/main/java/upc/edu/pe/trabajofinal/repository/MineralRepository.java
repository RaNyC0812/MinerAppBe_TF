package upc.edu.pe.trabajofinal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Mineral;
import upc.edu.pe.trabajofinal.model.Mineral_type;

import java.time.LocalDate;
import java.util.List;

@Repository
// kathy
public interface MineralRepository extends JpaRepository<Mineral, Integer> {
    @Query("SELECT m FROM Mineral m WHERE m.name LIKE %:nombre%")
    List<Mineral> findByNombre(@Param("nombre") String nombre);

    //Buscar Mineral con mas dureza que 6
    @Query("SELECT m FROM Mineral m WHERE m.hardness > :hardness")
    List<Mineral> findMineralsWithHardnessGreaterThan(@Param("hardness") String hardness);

    //Contal cuantos minerales hay por sede de la mineria
    @Query("SELECT m.mine.name, COUNT(m) FROM Mineral m GROUP BY m.mine.name")
    List<Object[]> countMineralsByMine();

    @Query("SELECT COUNT(m) FROM Mineral m WHERE m.fecha_extraccion BETWEEN :startDate AND :endDate")
    Long countMineralsExtractedByDateRange(LocalDate startDate, LocalDate endDate);

    @Query("SELECT m FROM Mineral m WHERE m.fecha_extraccion BETWEEN :startDate AND :endDate")
    List<Mineral> findMineralsExtractedByDateRange(LocalDate startDate, LocalDate endDate);
}
