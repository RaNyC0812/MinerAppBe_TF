package upc.edu.pe.trabajofinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.trabajofinal.model.Employee;

import upc.edu.pe.trabajofinal.model.Employee_type;
import upc.edu.pe.trabajofinal.repository.Employee_typeRepository;

import java.util.List;

@Service
public class EmployeeTypeService {
    @Autowired
    private Employee_typeRepository dR;

    //Insertar
    public void insert(Employee_type employeeType) {
        dR.save(employeeType);
    }
    //Listar
    public List<Employee_type> List(){
        return dR.findAll();
    }
    //Eliminar
    public void delete(int id) {
        dR.deleteById(id);
    }
    //Listar por ID
    public Employee_type listId(int id) {
        return dR.findById(id).orElse(new Employee_type());
    }
}
