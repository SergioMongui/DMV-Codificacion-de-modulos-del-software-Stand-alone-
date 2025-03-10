package com.Proyecto_Sena.Efi_Entregas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class ConexAsignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConexAsignacion;

    //Relacion de muchos a uno
    @ManyToOne

    //Indica que es una llave foranea
    @JoinColumn(name = "idPlanTrabajo", nullable = false)
    private PlanTrabajo planTrabajo;

    //Relacion de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDateTime fechaAsignacion;
}
