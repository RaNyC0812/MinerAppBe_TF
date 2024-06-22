package upc.edu.pe.trabajofinal.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.Mineral_typeDTO;
import upc.edu.pe.trabajofinal.model.Mineral_type;
import upc.edu.pe.trabajofinal.services.Mineral_typeService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo_mineral")
public class Mineral_typeController {
    @Autowired
    private Mineral_typeService dS;


    @PostMapping("/registrar") // ingresar datos
    @PreAuthorize("hasAnyAuthority('EMPLEADO')")
    public void registrar(@RequestBody Mineral_typeDTO mineralDTO){
        ModelMapper m = new ModelMapper();
        Mineral_type ds = m.map(mineralDTO, Mineral_type.class);

        dS.insert(ds); //insert
    }
    @GetMapping("/Listar") //Listar los datos
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public List<Mineral_typeDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,Mineral_typeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}") //eliminar los datos
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }
    @GetMapping("/{id}")
    public Mineral_typeDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        Mineral_typeDTO dto=m.map(dS.listId(id),Mineral_typeDTO.class);
        return dto;

    }
    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('EMPLEADO')")
    public void modificar(@RequestBody Mineral_typeDTO mineralDTO){
        ModelMapper d= new ModelMapper();
        Mineral_type mineralType=d.map(mineralDTO,Mineral_type.class);
        dS.insert(mineralType);
    }
    @PostMapping("/buscar")
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public List<Mineral_type> buscar(@RequestBody Mineral_type t) { return dS.search(t.getType());
    }


}
