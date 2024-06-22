package upc.edu.pe.trabajofinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.trabajofinal.model.Machinery;
import upc.edu.pe.trabajofinal.model.Machinery_type;
import upc.edu.pe.trabajofinal.repository.MachineryRepository;
import upc.edu.pe.trabajofinal.repository.Machinery_typeRepository;

import java.util.List;

//machinery service module insert list delete listID
@Service
public class Machinery_typeService {
    @Autowired
    private Machinery_typeRepository dR;

    //Insertar
    public void insert(Machinery_type machinery) {
        dR.save(machinery);
    }
    //Listar
    public List<Machinery_type> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Machinery_type listId(int id) {
        return dR.findById(id).orElse(new Machinery_type());
    }

}
