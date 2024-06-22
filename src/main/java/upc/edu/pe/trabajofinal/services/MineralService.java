package upc.edu.pe.trabajofinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.trabajofinal.model.Machinery;
import upc.edu.pe.trabajofinal.model.Mineral;
import upc.edu.pe.trabajofinal.model.Mineral_type;
import upc.edu.pe.trabajofinal.repository.MachineryRepository;
import upc.edu.pe.trabajofinal.repository.MineralRepository;

import java.time.LocalDate;
import java.util.List;

//Mineral service insert list delete
@Service
public class MineralService {
    @Autowired
    private MineralRepository dR;

    //Insertar
    public void insert(Mineral mineral) {
        dR.save(mineral);
    }
    //Listar
    public List<Mineral> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Mineral listId(int id) {
        return dR.findById(id).orElse(new Mineral());
    }

    public List<Mineral> search(String nombre) {

        return dR.findByNombre(nombre);
    }

    public List<Mineral> getMineralsWithHighHardness() {
        return dR.findMineralsWithHardnessGreaterThan("6");
    }

    public List<Object[]> getMineralCountByMine() {
        return dR.countMineralsByMine();
    }
    public Long countMineralsExtractedByDateRange(LocalDate startDate, LocalDate endDate) {
        return dR.countMineralsExtractedByDateRange(startDate, endDate);
    }

    public List<Mineral> findMineralsExtractedByDateRange(LocalDate startDate, LocalDate endDate) {
        return dR.findMineralsExtractedByDateRange(startDate, endDate);
    }

}
