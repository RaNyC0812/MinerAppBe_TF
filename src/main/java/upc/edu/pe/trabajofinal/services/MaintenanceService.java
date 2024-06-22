package upc.edu.pe.trabajofinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.trabajofinal.model.Machinery;
import upc.edu.pe.trabajofinal.model.Maintenance;
import upc.edu.pe.trabajofinal.repository.MachineryRepository;
import upc.edu.pe.trabajofinal.repository.MaintenanceRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository dR;

    //Insertar
    public void insert(Maintenance maintenance) {
        dR.save(maintenance);
    }
    //Listar
    public List<Maintenance> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Maintenance listId(int id) {
        return dR.findById(id).orElse(new Maintenance());
    }
    public List<Maintenance> findByMachineryTypeName(String machineryTypeName) {
        return dR.findByMachineryTypeName(machineryTypeName);
    }
    public List<Object[]> countMaintenanceByMachine() {
        return dR.countMaintenanceByMachine();
    }

    public List<Maintenance> findByMaintenanceDate(LocalDate fecha) {
        return dR.findByMaintenanceDate(fecha);
    }

    public List<Object[]> findTotalMaintenanceCostByMonth() {
        return dR.findTotalMaintenanceCostByMonth();
    }
}
