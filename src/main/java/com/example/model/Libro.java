package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libri") // Specifica il nome della tabella nel database
public class Libro extends Catalogo {

    private String autore; // Campo specifico di Libro
    private String genere; // Campo specifico di Libro

    // Getters e Setters
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
