package upc.edu.pe.trabajofinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upc.edu.pe.trabajofinal.model.Machinery;

import upc.edu.pe.trabajofinal.repository.MachineryRepository;
import java.util.List;

@Service
public class MachineryService {
    @Autowired
    private MachineryRepository dR;

    //Insertar
    public void insert(Machinery machinery) {
        dR.save(machinery);
    }
    //Listar
    public List<Machinery> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Machinery listId(int id) {
        return dR.findById(id).orElse(new Machinery());
    }


    public List<Object[]> contarMaquinariaPorModelo() {
        return dR.countMachineryByModel();
    }
    public List<Machinery> buscarModelo(String modelo) {
        return dR.buscarModelo(modelo);
    }

}
