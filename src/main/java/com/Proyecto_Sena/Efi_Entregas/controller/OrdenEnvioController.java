package com.Proyecto_Sena.Efi_Entregas.controller;

import com.Proyecto_Sena.Efi_Entregas.model.OrdenEnvio;
import com.Proyecto_Sena.Efi_Entregas.repository.OrdenEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenenvio")
public class OrdenEnvioController {

    @Autowired
    private OrdenEnvioRepository ordenEnvioRepository;

    @PostMapping
    public OrdenEnvio create(@RequestBody OrdenEnvio ordenEnvio) {
        return ordenEnvioRepository.save(ordenEnvio);
    }

    @GetMapping
    public List<OrdenEnvio> getAll() {
        return ordenEnvioRepository.findAll();
    }

    @GetMapping("/{id}")
    public OrdenEnvio getById(@PathVariable Long id) {
        return ordenEnvioRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public OrdenEnvio update(@PathVariable Long id, @RequestBody OrdenEnvio ordenEnvio) {
        ordenEnvio.setIdOrden(id);
        return ordenEnvioRepository.save(ordenEnvio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ordenEnvioRepository.deleteById(id);
    }

}
