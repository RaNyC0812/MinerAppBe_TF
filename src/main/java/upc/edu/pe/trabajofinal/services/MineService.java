package upc.edu.pe.trabajofinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.trabajofinal.model.Mine;
import upc.edu.pe.trabajofinal.repository.MineRepository;

import java.util.List;

//Services miner
@Service
public class MineService {
    @Autowired
    private MineRepository dR;

    //Insertar
    public void insert(Mine mine) {
        dR.save(mine);
    }
    //Listar
    public List<Mine> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Mine listId(int id) {
        return dR.findById(id).orElse(new Mine());
    }

}
