package upc.edu.pe.trabajofinal.controllers;

import org.aspectj.weaver.ast.Not;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.trabajofinal.dto.MineralDTO;
import upc.edu.pe.trabajofinal.dto.NotificationDTO;
import upc.edu.pe.trabajofinal.model.Employee;
import upc.edu.pe.trabajofinal.model.Machinery;
import upc.edu.pe.trabajofinal.model.Mineral;
import upc.edu.pe.trabajofinal.model.Notification;
import upc.edu.pe.trabajofinal.services.MineralService;
import upc.edu.pe.trabajofinal.services.NotificationService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificacion")
public class NotificationController {
    @Autowired
    private NotificationService dS;


    @PostMapping("/registrar") // ingresar datos
    @PreAuthorize("hasAnyAuthority('EMPLEADO')")
    public void registrar(@RequestBody NotificationDTO notificationDTO){
        ModelMapper m = new ModelMapper();
        Notification ds = m.map(notificationDTO,Notification.class);

        dS.insert(ds); //insert
    }
    @GetMapping("/Listar") //Listar los datos
    @PreAuthorize("hasAnyAuthority('JEFE','EMPLEADO')")
    public List<NotificationDTO> Listar(){
        return dS.List().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NotificationDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}") //eliminar los datos
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }
    @GetMapping("/{id}")
    public NotificationDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        NotificationDTO dto=m.map(dS.listId(id),NotificationDTO.class);
        return dto;

    }
    @PutMapping("/modificar")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody NotificationDTO mineralDTO){
        ModelMapper d= new ModelMapper();
        Notification notification=d.map(mineralDTO,Notification.class);
        dS.insert(notification);
    }

    @GetMapping("/ContarNotificacionesXMina")
    public List<Object[]> getNotificationCountByMine() {
        return dS.getNotificationCountByMine();
    }

   /* @PostMapping("/buscarEstado")
    public List<Notification> buscar(@RequestBody Notification t) { return dS.search(t.getCurrentStatus());
    }*/
    @GetMapping("/buscarPorEstado")
    public List<Notification> buscar(@RequestParam("currentStatus") String status) {
        return dS.search(status);
    }

    @GetMapping("/BuscarNotiRangoDeFecha")
    public List<Notification> getNotificationsByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return dS.findNotificationsByDateRange(startDate, endDate);
    }
    @GetMapping("/contarNotixEmpleado")
    public List<Object[]> countNotificationsByEmployee() {
        return dS.countNotificationsByEmployee();
    }
    @GetMapping("/InforNotixEmpleado") //buscar el nombre del empleado y sale la notifiacion
    public List<Notification> getNotificationsByEmployee(@RequestParam("employeeName") String employeeName) {
        return dS.findNotificationsByEmployee(employeeName);
    }
    @GetMapping("/InfoNotixMina")
    public List<Notification> getNotificationsByMine(@RequestParam("mineName") String mineName) {
        return dS.findNotificationsByMine(mineName);
    }
}
