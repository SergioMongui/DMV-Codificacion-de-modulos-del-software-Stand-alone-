package com.Proyecto_Sena.Efi_Entregas.service;

import com.Proyecto_Sena.Efi_Entregas.model.ConexOrdenPlanTrabajo;
import com.Proyecto_Sena.Efi_Entregas.repository.ConexOrdenPlanTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConexOrdenPlanTrabajoService {

    @Autowired
    private ConexOrdenPlanTrabajoRepository conexOrdenPlanTrabajoRepository;

    public List<ConexOrdenPlanTrabajo> getAll() {
        return conexOrdenPlanTrabajoRepository.findAll();
    }

    public Optional<ConexOrdenPlanTrabajo> getById(Long id) {
        return conexOrdenPlanTrabajoRepository.findById(id);
    }

    public ConexOrdenPlanTrabajo save(ConexOrdenPlanTrabajo conexOrdenPlanTrabajo) {
        return conexOrdenPlanTrabajoRepository.save(conexOrdenPlanTrabajo);
    }

    public void delete(Long id) {
        conexOrdenPlanTrabajoRepository.deleteById(id);
    }
}
