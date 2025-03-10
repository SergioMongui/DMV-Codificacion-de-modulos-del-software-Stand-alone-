package com.Proyecto_Sena.Efi_Entregas.controller;

import com.Proyecto_Sena.Efi_Entregas.model.ConexAsignacion;
import com.Proyecto_Sena.Efi_Entregas.repository.ConexAsignacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conexasignaciones")
public class ConexAsignacionController {
    @Autowired
    private ConexAsignacionRepository conexAsignacionRepository;

    @PostMapping
    public ConexAsignacion create(@RequestBody ConexAsignacion conexAsignacion) {
        return conexAsignacionRepository.save(conexAsignacion);
    }

    @GetMapping
    public List<ConexAsignacion> getAll() {
        return conexAsignacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ConexAsignacion getById(@PathVariable Long id) {
        return conexAsignacionRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ConexAsignacion update(@PathVariable Long id, @RequestBody ConexAsignacion conexAsignacion) {
        conexAsignacion.setIdConexAsignacion(id);
        return conexAsignacionRepository.save(conexAsignacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conexAsignacionRepository.deleteById(id);
    }
}
