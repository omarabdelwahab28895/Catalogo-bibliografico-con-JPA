package com.example.model;

import jakarta.persistence.*;

@MappedSuperclass // Indica che questa classe è una base astratta per le entità
public abstract class Catalogo {

    @Id
    private String isbn;

    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    // Getters e Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
