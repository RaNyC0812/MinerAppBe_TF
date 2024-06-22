package upc.edu.pe.trabajofinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.trabajofinal.model.Employee;
import upc.edu.pe.trabajofinal.repository.EmployeeRepository;


import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository dR;

    //Insertar
    public void insert(Employee employee) {
        dR.save(employee);
    }
    //Listar
    public List<Employee> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Employee listId(int id) {
        return dR.findById(id).orElse(new Employee());
    }

    public List<Employee> buscarNombre(String buscaNombre) {
        return dR.buscarNombre(buscaNombre);
    }
    public List<Employee> buscarApellido(String buscaApellido) {
        return dR.buscarApellido(buscaApellido);
    }
    public List<Employee> buscarGenero(String genero) {
        return dR.buscarGenero(genero);
    }

    public List<Employee> buscarDepartemento(String Departamento) {
        return dR.buscarDepartamento(Departamento);
    }



}
