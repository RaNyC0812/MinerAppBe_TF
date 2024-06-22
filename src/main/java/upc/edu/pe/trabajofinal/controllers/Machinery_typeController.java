package upc.edu.pe.trabajofinal.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.MachineryDTO;
import upc.edu.pe.trabajofinal.dto.Machinery_typeDTO;
import upc.edu.pe.trabajofinal.model.Machinery;
import upc.edu.pe.trabajofinal.model.Machinery_type;
import upc.edu.pe.trabajofinal.services.MachineryService;
import upc.edu.pe.trabajofinal.services.Machinery_typeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo_maquinaria")
public class Machinery_typeController {
    @Autowired
    private Machinery_typeService dS;


    @PostMapping("/registrar") // ingresar datos
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public void registrar(@RequestBody Machinery_typeDTO machineryTypeDTO){
        ModelMapper m = new ModelMapper();
        Machinery_type ds = m.map(machineryTypeDTO, Machinery_type.class);

        dS.insert(ds); //insert
    }
    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public List<Machinery_typeDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,Machinery_typeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }

    @GetMapping("/{id}")
    public Machinery_typeDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        Machinery_typeDTO  dto=m.map(dS.listId(id),Machinery_typeDTO .class);
        return dto;

    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public void modificar(@RequestBody Machinery_typeDTO  machineryDTO){
        ModelMapper d= new ModelMapper();
        Machinery_type machinery=d.map(machineryDTO,Machinery_type.class);
        dS.insert(machinery);
    }

}
