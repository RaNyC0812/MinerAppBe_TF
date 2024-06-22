package upc.edu.pe.trabajofinal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.trabajofinal.model.Machinery_type;

@Repository
public interface Machinery_typeRepository extends JpaRepository<Machinery_type, Integer> {

}
