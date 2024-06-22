package upc.edu.pe.trabajofinal.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.MaintenanceDTO;

import upc.edu.pe.trabajofinal.model.Maintenance;
import upc.edu.pe.trabajofinal.services.MaintenanceService;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mantenimiento")
public class MaintenanceController {
    @Autowired
    private MaintenanceService dS;


    @PostMapping("/registrar") // ingresar datos
    @PreAuthorize("hasAnyAuthority('EMPLEADO')")
    public void registrar(@RequestBody MaintenanceDTO maintenanceDTO){
        ModelMapper m = new ModelMapper();
        Maintenance ds = m.map(maintenanceDTO, Maintenance.class);

        dS.insert(ds); //insert
    }
    @GetMapping("/Listar") //Listar los datos
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public List<MaintenanceDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MaintenanceDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}") //eliminar los datos
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }

    @GetMapping("/{id}")
    public MaintenanceDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        MaintenanceDTO dto=m.map(dS.listId(id),MaintenanceDTO.class);
        return dto;

    }
    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public void modificar(@RequestBody MaintenanceDTO maintenanceDTO){
        ModelMapper d= new ModelMapper();
        Maintenance maintenance=d.map(maintenanceDTO,Maintenance.class);
        dS.insert(maintenance);
    }
    @GetMapping("/por-tipo-maquinaria")
    public ResponseEntity<List<Maintenance>> getMantenimientosPorTipoMaquinaria(@RequestParam("tipoMaquinaria") String tipoMaquinaria) {
        List<Maintenance> mantenimientos = dS.findByMachineryTypeName(tipoMaquinaria);
        return ResponseEntity.ok(mantenimientos);
    }
    @GetMapping("/contarxMaquinaria")
    public ResponseEntity<List<Object[]>> countMaintenanceByMachine() {
        List<Object[]> result = dS.countMaintenanceByMachine();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/por-fecha")
    public ResponseEntity<List<Maintenance>> getMaintenanceByDate(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        List<Maintenance> maintenanceList = dS.findByMaintenanceDate(fecha);
        return ResponseEntity.ok(maintenanceList);
    }

    @GetMapping("/CostoTotalPorMes")
    public List<Object[]> getTotalMaintenanceCostByMonth() {
        return dS.findTotalMaintenanceCostByMonth();
    }
}
