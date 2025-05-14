package com.Proyecto_Sena.Efi_Entregas.service;

import com.Proyecto_Sena.Efi_Entregas.model.PlanTrabajo;
import com.Proyecto_Sena.Efi_Entregas.repository.PlanTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanTrabajoService {

    @Autowired
    private PlanTrabajoRepository planTrabajoRepository;

    public List<PlanTrabajo> getAll() {
        return planTrabajoRepository.findAll();
    }

    public Optional<PlanTrabajo> getById(Long id) {
        return planTrabajoRepository.findById(id);
    }

    public PlanTrabajo save(PlanTrabajo planTrabajo) {
        return planTrabajoRepository.save(planTrabajo);
    }

    public void delete(Long id) {
        planTrabajoRepository.deleteById(id);
    }
}
