package upc.edu.pe.trabajofinal.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.Employee_typeDTO;
import upc.edu.pe.trabajofinal.model.Employee_type;
import upc.edu.pe.trabajofinal.services.EmployeeTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo_empleado")
public class Employee_typeController {

    @Autowired
    private EmployeeTypeService dS;


    @PostMapping("/registrar") // ingresar datos
    //Spring Security employee module
    @PreAuthorize("hasAnyAuthority('JEFE')")
    public void registrar(@RequestBody Employee_typeDTO employeeTypeDTO){
        ModelMapper m = new ModelMapper();
        Employee_type ds = m.map(employeeTypeDTO, Employee_type.class);

        dS.insert(ds); //insert
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('JEFE')")
    public List<Employee_typeDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,Employee_typeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }

    @GetMapping("/{id}")
    public Employee_typeDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        Employee_typeDTO dto=m.map(dS.listId(id),Employee_typeDTO.class);
        return dto;

    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('JEFE')")
    public void modificar(@RequestBody Employee_typeDTO employeeTypeDTO){
        ModelMapper d= new ModelMapper();
        Employee_type employeeType=d.map(employeeTypeDTO,Employee_type.class);
        dS.insert(employeeType);
    }

}
