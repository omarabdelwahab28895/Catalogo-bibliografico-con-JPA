package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "riviste")
public class Rivista extends Catalogo {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Periodicita periodicita;

    // Getter e Setter
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
