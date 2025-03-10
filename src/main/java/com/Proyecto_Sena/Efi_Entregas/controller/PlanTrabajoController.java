package com.Proyecto_Sena.Efi_Entregas.controller;

import com.Proyecto_Sena.Efi_Entregas.model.PlanTrabajo;
import com.Proyecto_Sena.Efi_Entregas.repository.PlanTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planetrabajo")
public class PlanTrabajoController {
    @Autowired
    private PlanTrabajoRepository planTrabajoRepository;

    @PostMapping
    public PlanTrabajo create(@RequestBody PlanTrabajo planTrabajo) {
        return planTrabajoRepository.save(planTrabajo);
    }

    @GetMapping
    public List<PlanTrabajo> getAll() {
        return planTrabajoRepository.findAll();
    }

    @GetMapping("/{id}")
    public PlanTrabajo getById(@PathVariable Long id) {
        return planTrabajoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public PlanTrabajo update(@PathVariable Long id, @RequestBody PlanTrabajo planTrabajo) {
        planTrabajo.setIdPlanTrabajo(id);
        return planTrabajoRepository.save(planTrabajo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planTrabajoRepository.deleteById(id);
    }
}
