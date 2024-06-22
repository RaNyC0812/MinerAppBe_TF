package upc.edu.pe.trabajofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Maintenance;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {

    @Query("SELECT m.machinery.name, COUNT(m) " +
            "FROM Maintenance m " +
            "GROUP BY m.machinery.name")
    List<Object[]> countMaintenanceByMachine();

    @Query("SELECT m " +
            "FROM Maintenance m " +
            "JOIN m.machinery mach " +
            "WHERE mach.machineryType.machinery_type_name = :machineryTypeName")
    List<Maintenance> findByMachineryTypeName(@Param("machineryTypeName") String machineryTypeName);

    @Query("SELECT m " +
            "FROM Maintenance m " +
            "WHERE m.maintenance_date = :fecha")
    List<Maintenance> findByMaintenanceDate(@Param("fecha") LocalDate fecha);

    @Query("SELECT MONTH(m.maintenance_date) AS month, SUM(m.cost) AS totalCost " +
            "FROM Maintenance m " +
            "GROUP BY MONTH(m.maintenance_date)")
    List<Object[]> findTotalMaintenanceCostByMonth();

}
