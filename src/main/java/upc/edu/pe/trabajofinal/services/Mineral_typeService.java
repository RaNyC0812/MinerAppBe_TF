package upc.edu.pe.trabajofinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.trabajofinal.model.Machinery;
import upc.edu.pe.trabajofinal.model.Mineral;
import upc.edu.pe.trabajofinal.model.Mineral_type;
import upc.edu.pe.trabajofinal.repository.MachineryRepository;
import upc.edu.pe.trabajofinal.repository.Mineral_typeRepository;

import java.util.List;

@Service
public class Mineral_typeService {
    @Autowired
    private Mineral_typeRepository dR;

    //Insertar
    public void insert(Mineral_type mineralType) {
        dR.save(mineralType);
    }
    //Listar
    public List<Mineral_type> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Mineral_type listId(int id) {
        return dR.findById(id).orElse(new Mineral_type());
    }

    public List<Mineral_type> search(String mineral) {

        return dR.findByType(mineral);
    }

}
