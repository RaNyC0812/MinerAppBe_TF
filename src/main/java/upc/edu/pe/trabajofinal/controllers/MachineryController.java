package upc.edu.pe.trabajofinal.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.EmployeeDTO;
import upc.edu.pe.trabajofinal.dto.MachineryDTO;
import upc.edu.pe.trabajofinal.dto.ModelCountDto;
import upc.edu.pe.trabajofinal.model.Employee;
import upc.edu.pe.trabajofinal.model.Machinery;
import upc.edu.pe.trabajofinal.services.MachineryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maquinaria")
public class MachineryController {
    @Autowired
    private MachineryService dS;


    @PostMapping("/registrar") // ingresar datos
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public void registrar(@RequestBody MachineryDTO dish){
        ModelMapper m = new ModelMapper();
        Machinery ds = m.map(dish, Machinery.class);

        dS.insert(ds); //insert
    }
    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public List<MachineryDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MachineryDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }

    @GetMapping("/{id}")
    public MachineryDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        MachineryDTO dto=m.map(dS.listId(id),MachineryDTO.class);
        return dto;

    }

    @PutMapping("/modificar")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody MachineryDTO machineryDTO){
        ModelMapper d= new ModelMapper();
        Machinery machinery=d.map(machineryDTO,Machinery.class);
        dS.insert(machinery);
    }

    //Reporte
    @GetMapping("/contarPorModelo")
    public ResponseEntity<List<ModelCountDto>> contarMaquinariaPorModelo() {
        List<Object[]> results = dS.contarMaquinariaPorModelo();

        List<ModelCountDto> response = new ArrayList<>();
        for (Object[] result : results) {
            String modelo = (String) result[0];
            Long cantidad = (Long) result[1];
            response.add(new ModelCountDto(modelo, cantidad));
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscarPorModelo")
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public List<Machinery> buscarPorGenero(@RequestParam("model") String model) {
        return dS.buscarModelo(model);
    }
}
