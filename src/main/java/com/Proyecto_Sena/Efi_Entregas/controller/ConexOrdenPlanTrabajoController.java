package com.Proyecto_Sena.Efi_Entregas.controller;

import com.Proyecto_Sena.Efi_Entregas.model.ConexOrdenPlanTrabajo;
import com.Proyecto_Sena.Efi_Entregas.repository.ConexOrdenPlanTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conexordenplantrabajo")
public class ConexOrdenPlanTrabajoController {
     @Autowired
    private ConexOrdenPlanTrabajoRepository conexOrdenPlanTrabajoRepository;

    @PostMapping
    public ConexOrdenPlanTrabajo create(@RequestBody ConexOrdenPlanTrabajo conexOrdenPlanTrabajo) {
        return conexOrdenPlanTrabajoRepository.save(conexOrdenPlanTrabajo);
    }

    @GetMapping
    public List<ConexOrdenPlanTrabajo> getAll() {
        return conexOrdenPlanTrabajoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ConexOrdenPlanTrabajo getById(@PathVariable Long id) {
        return conexOrdenPlanTrabajoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ConexOrdenPlanTrabajo update(@PathVariable Long id, @RequestBody ConexOrdenPlanTrabajo conexOrdenPlanTrabajo) {
        conexOrdenPlanTrabajo.setIdConexOrdenPlanTrabajo(id);
        return conexOrdenPlanTrabajoRepository.save(conexOrdenPlanTrabajo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conexOrdenPlanTrabajoRepository.deleteById(id);
    }    
}
