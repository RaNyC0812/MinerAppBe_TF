package upc.edu.pe.trabajofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE %:firstName%")
    List<Employee> buscarNombre(@Param("firstName") String firstName);

    @Query("SELECT e FROM Employee e WHERE e.lastName LIKE %:lastName%")
    List<Employee> buscarApellido(@Param("lastName") String lastName);

    @Query("SELECT e FROM Employee e WHERE e.gender = :gender")
    List<Employee> buscarGenero(@Param("gender") String gender);

    @Query("SELECT e FROM Employee e WHERE e.department = :deparment")
    List<Employee> buscarDepartamento(@Param("deparment") String deparment);



}
