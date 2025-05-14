package com.Proyecto_Sena.Efi_Entregas.controller;

import com.Proyecto_Sena.Efi_Entregas.model.ConexOrdenPlanTrabajo;
import com.Proyecto_Sena.Efi_Entregas.model.OrdenEnvio;
import com.Proyecto_Sena.Efi_Entregas.model.PlanTrabajo;
import com.Proyecto_Sena.Efi_Entregas.model.PlanTrabajoRequest;
import com.Proyecto_Sena.Efi_Entregas.repository.ConexOrdenPlanTrabajoRepository;
import com.Proyecto_Sena.Efi_Entregas.service.PlanTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/planes-trabajo")
public class PlanTrabajoController {

    @Autowired
    private PlanTrabajoService planTrabajoService;

    @Autowired
    private ConexOrdenPlanTrabajoRepository conexOrdenPlanTrabajoRepository;

    @GetMapping
    public List<PlanTrabajo> getAll() {
        return planTrabajoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanTrabajo> getById(@PathVariable Long id) {
        return planTrabajoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PlanTrabajo create(@RequestBody PlanTrabajo planTrabajo) {
        return planTrabajoService.save(planTrabajo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanTrabajo> update(@PathVariable Long id, @RequestBody PlanTrabajo planTrabajo) {
        return planTrabajoService.getById(id)
                .map(existing -> {
                    planTrabajo.setIdPlanTrabajo(id);
                    return ResponseEntity.ok(planTrabajoService.save(planTrabajo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<PlanTrabajo> plan = planTrabajoService.getById(id);
        if (plan.isPresent()) {
            planTrabajoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creacion-ordenes")
    public ResponseEntity<PlanTrabajo> crearPlanConOrdenes(@RequestBody PlanTrabajoRequest request) {
        if (request.getOrdenes() == null || request.getOrdenes().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // creacion nuevo plan
        PlanTrabajo nuevoPlan = new PlanTrabajo();
        nuevoPlan.setEstadoPT("pendiente");
        PlanTrabajo planGuardado = planTrabajoService.save(nuevoPlan);

        // conexiones orden-plan
        for (Long idOrden : request.getOrdenes()) {
            ConexOrdenPlanTrabajo conexion = new ConexOrdenPlanTrabajo();
            conexion.setPlanTrabajo(planGuardado);

            OrdenEnvio orden = new OrdenEnvio();
            orden.setIdOrden(idOrden); // si se necesita setear el ID
            conexion.setOrdenEnvio(orden);

            conexion.setFechaCreacion(java.time.LocalDateTime.now());

            conexOrdenPlanTrabajoRepository.save(conexion);
        }

        return ResponseEntity.ok(planGuardado);
    }

}
