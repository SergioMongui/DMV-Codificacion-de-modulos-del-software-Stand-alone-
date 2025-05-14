package com.Proyecto_Sena.Efi_Entregas.model;

import java.util.List;

public class PlanTrabajoRequest {
    private List<Long> ordenes;

    public List<Long> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Long> ordenes) {
        this.ordenes = ordenes;
    }
}
