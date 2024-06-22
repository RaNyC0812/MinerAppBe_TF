package upc.edu.pe.trabajofinal.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.MineDTO;
import upc.edu.pe.trabajofinal.model.Mine;
import upc.edu.pe.trabajofinal.services.MineService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mine")
public class MineController {
    @Autowired
    private MineService dS;


    @PostMapping("/registrar") // ingresar datos
    @PreAuthorize("hasAnyAuthority('JEFE')")
    public void registrar(@RequestBody MineDTO mine){
        ModelMapper m = new ModelMapper();
        Mine ds = m.map(mine, Mine.class);

        dS.insert(ds); //insert
    }
    @GetMapping("/Listar") //Listar los datos
    @PreAuthorize("hasAnyAuthority('JEFE')")
    public List<MineDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MineDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}") //eliminar los datos
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }
    @GetMapping("/{id}")
    public MineDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        MineDTO dto=m.map(dS.listId(id),MineDTO.class);
        return dto;

    }
    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('JEFE')")
    public void modificar(@RequestBody MineDTO answerDTO){
        ModelMapper d= new ModelMapper();
        Mine answer=d.map(answerDTO,Mine.class);
        dS.insert(answer);}

}
