package upc.edu.pe.trabajofinal.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.MineDTO;
import upc.edu.pe.trabajofinal.dto.MineralDTO;
import upc.edu.pe.trabajofinal.model.Mine;
import upc.edu.pe.trabajofinal.model.Mineral;
import upc.edu.pe.trabajofinal.services.MineService;
import upc.edu.pe.trabajofinal.services.MineralService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mineral")
public class MineralController {
    @Autowired
    private MineralService dS;

    //Manejador de una solicitud HTTP POST
    @PostMapping("/registrar") // ingresar/registrar datos
    //Spring Security
    @PreAuthorize("hasAnyAuthority('EMPLEADO')") //Authorizer access a register
    public void registrar(@RequestBody MineralDTO mineralDTO){
        ModelMapper m = new ModelMapper();
        Mineral ds = m.map(mineralDTO, Mineral.class);

        dS.insert(ds); //insert
    }
    @GetMapping("/Listar") //Listar los datos
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public List<MineralDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MineralDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}") //eliminar los datos
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }
    @GetMapping("/{id}")
    public MineralDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        MineralDTO dto=m.map(dS.listId(id),MineralDTO.class);
        return dto;

    }
    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('EMPLEADO')")
    public void modificar(@RequestBody MineralDTO mineralDTO){
        ModelMapper d= new ModelMapper();
        Mineral mineral=d.map(mineralDTO,Mineral.class);
        dS.insert(mineral);
    }
    @PostMapping("/buscar")
    public List<Mineral> buscar(@RequestBody Mineral t) { return dS.search(t.getName());
    }

    @GetMapping("/AltaDureza") //Mayor que 6 se considerara alta dureza
    public List<Mineral> getMineralsWithHighHardness() {
        return dS.getMineralsWithHighHardness();
    }

    @GetMapping("ContarMineralxMina")
    public List<Object[]> getMineralCountByMine() {
        return dS.getMineralCountByMine();
    }
    @GetMapping("/CantidadMineralxFecha")
    public Long countMineralsExtractedByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return dS.countMineralsExtractedByDateRange(startDate, endDate);
    }
    //solicitud HTTP GET recuperar lista de recursos
    @GetMapping("/InfoMineralxRangoFecha")
    public List<Mineral> getMineralsExtractedByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return dS.findMineralsExtractedByDateRange(startDate, endDate);
    }
}
