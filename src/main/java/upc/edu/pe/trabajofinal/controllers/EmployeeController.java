package upc.edu.pe.trabajofinal.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.EmployeeDTO;
import upc.edu.pe.trabajofinal.model.Employee;
import upc.edu.pe.trabajofinal.services.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleado")
public class EmployeeController {
    @Autowired
    private EmployeeService dS;


    @PostMapping("/registrar") // ingresar datos
    @PreAuthorize("hasAnyAuthority('JEFE')")
    public void registrar(@RequestBody EmployeeDTO dish){
        ModelMapper m = new ModelMapper();
        Employee ds = m.map(dish, Employee.class);

        dS.insert(ds); //insert
    }
    @GetMapping("/listar")

    public List<EmployeeDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,EmployeeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }

    @GetMapping("/{id}")
    public EmployeeDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        EmployeeDTO dto=m.map(dS.listId(id),EmployeeDTO.class);
        return dto;

    }

    @PutMapping("/modificar")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody EmployeeDTO answerDTO){
        ModelMapper d= new ModelMapper();
        Employee answer=d.map(answerDTO,Employee.class);
        dS.insert(answer);
    }
    @GetMapping("/buscarPorNombreYApellido")
    public List<Employee> buscarPorNombreYApellido(
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido) {

        List<Employee> empleadosPorNombre = dS.buscarNombre(nombre);
        List<Employee> empleadosPorApellido = dS.buscarApellido(apellido);

        // Intersección de las listas para obtener empleados que cumplen ambas condiciones
        empleadosPorNombre.retainAll(empleadosPorApellido);

        return empleadosPorNombre;
    }

    @GetMapping("/buscarPorGenero")
    public List<Employee> buscarPorGenero(@RequestParam("gender") String genero) {
        return dS.buscarGenero(genero);
    }
    @GetMapping("/buscarPorDepartamento")
    public List<Employee> buscarPorTitulo(@RequestParam("deparment") String deparment) {
        return dS.buscarDepartemento(deparment);
    }
}
