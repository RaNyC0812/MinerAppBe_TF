package upc.edu.pe.trabajofinal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.trabajofinal.model.Users;
import upc.edu.pe.trabajofinal.repository.UserRepository;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UserRepository uR;


    public void insert(Users usuario) {
        uR.save(usuario);
    }


    public List<Users> list() {
        return uR.findAll();
    }


    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }


    public Users listarId(Long idUsuario) {
        return uR.findById(idUsuario).orElse(new Users());
    }

}
