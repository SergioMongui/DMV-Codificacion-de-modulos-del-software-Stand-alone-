package com.Proyecto_Sena.Efi_Entregas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Proyecto_Sena.Efi_Entregas.model.Usuario;

//Extendemos de la clase padre JpaRepository para que nos agregue los metodos de CRUD
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
