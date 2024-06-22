package upc.edu.pe.trabajofinal.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.Notification_typeDTO;
import upc.edu.pe.trabajofinal.model.Notification_type;
import upc.edu.pe.trabajofinal.services.Notification_typeService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo_notificacion")
public class Notification_typeController {
    @Autowired
    private Notification_typeService dS;


    @PostMapping("/registrar") // ingresar datos
    @PreAuthorize("hasAnyAuthority('EMPLEADO')")
    public void registrar(@RequestBody Notification_typeDTO notificationTypeDTO){
        ModelMapper m = new ModelMapper();
        Notification_type ds = m.map(notificationTypeDTO, Notification_type.class);
        dS.insert(ds); //insert
    }
    @GetMapping("/Listar") //Listar los datos
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public List<Notification_typeDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,Notification_typeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}") //eliminar los datos
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }
    @GetMapping("/{id}")
    public Notification_typeDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        Notification_typeDTO dto=m.map(dS.listId(id),Notification_typeDTO.class);
        return dto;

    }
    @PutMapping("/modificar")

    public void modificar(@RequestBody Notification_typeDTO notificationTypeDTO){
        ModelMapper d= new ModelMapper();
        Notification_type notificationType=d.map(notificationTypeDTO,Notification_type.class);
        dS.insert(notificationType);
    }
}
