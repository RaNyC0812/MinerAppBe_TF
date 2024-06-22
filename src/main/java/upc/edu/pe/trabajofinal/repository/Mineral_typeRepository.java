package upc.edu.pe.trabajofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Mineral_type;

import java.util.List;

//type mineral repository module
@Repository
public interface Mineral_typeRepository extends JpaRepository<Mineral_type,Integer> {
    @Query("SELECT mt FROM Mineral_type mt WHERE mt.type LIKE %:tipoMineral%")
    List<Mineral_type> findByType(@Param("tipoMineral") String tipoMineral);
}
