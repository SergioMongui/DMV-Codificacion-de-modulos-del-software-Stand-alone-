package com.Proyecto_Sena.Efi_Entregas.controller;

import com.Proyecto_Sena.Efi_Entregas.model.Usuario;
import com.Proyecto_Sena.Efi_Entregas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//indica que esta clase es un controlador de spring y maneja solicitudes http
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    /*Autowired permite tomar las instancias creadas en 
    *UsuariosRepository y usarlas en UsuarioController de forma automatica, 
    *sin necesidad de un controlador */
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Mapea metodos a operaciones http, en este caso crear un usuario
    @PostMapping

    //atributo usuario y RequestBody indica que el parametro "Usuario usuario" se obtenga del cuerpo de la solictud HTTP
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Tomar todos los usuarios
    @GetMapping
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    // Tomar un usuario por ID
    @GetMapping("/{id}")

    /*PathVariable toma valores de la url en este caso id 
    * que pasa a ser parametro del metodo, si no encuentra devuelve nulo*/
    public Usuario getById(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
