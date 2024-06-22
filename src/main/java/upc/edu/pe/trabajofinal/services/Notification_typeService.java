package upc.edu.pe.trabajofinal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upc.edu.pe.trabajofinal.model.Notification_type;

import upc.edu.pe.trabajofinal.repository.Notification_typeRepository;

import java.util.List;


@Service
public class Notification_typeService {
    @Autowired
    private Notification_typeRepository dR;

    //Insertar
    public void insert(Notification_type notificationType) {
        dR.save(notificationType);
    }
    //Listar
    public List<Notification_type> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Notification_type listId(int id) {
        return dR.findById(id).orElse(new Notification_type());
    }

}
