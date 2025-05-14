package com.Proyecto_Sena.Efi_Entregas.service;

import com.Proyecto_Sena.Efi_Entregas.model.ConexAsignacion;
import com.Proyecto_Sena.Efi_Entregas.repository.ConexAsignacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConexAsignacionService {

    @Autowired
    private ConexAsignacionRepository conexAsignacionRepository;

    public List<ConexAsignacion> getAll() {
        return conexAsignacionRepository.findAll();
    }

    public Optional<ConexAsignacion> getById(Long id) {
        return conexAsignacionRepository.findById(id);
    }

    public ConexAsignacion save(ConexAsignacion conexAsignacion) {
        return conexAsignacionRepository.save(conexAsignacion);
    }

    public void delete(Long id) {
        conexAsignacionRepository.deleteById(id);
    }
}
