package upc.edu.pe.trabajofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Employee;
import upc.edu.pe.trabajofinal.model.Machinery;

import java.util.List;

@Repository
public interface MachineryRepository extends JpaRepository<Machinery, Integer> {

    @Query("SELECT m.model, COUNT(m) FROM Machinery m GROUP BY m.model")
    List<Object[]> countMachineryByModel();

    @Query("SELECT e FROM Machinery e WHERE e.model LIKE %:model%")
    List<Machinery> buscarModelo(@Param("model") String model);


}
