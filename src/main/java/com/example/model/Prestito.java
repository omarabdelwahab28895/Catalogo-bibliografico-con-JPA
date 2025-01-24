package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestiti") // Nome della tabella nel database
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id") // Nome della colonna FK per l'utente
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_prestato_id") // Nome della colonna FK per il catalogo
    private Libro elementoPrestato; // Modificato da Catalogo a Libro (se non hai altre entità figlie)

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;

    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva", nullable = true) // Può essere null
    private LocalDate dataRestituzioneEffettiva;

    // Costruttore vuoto
    public Prestito() {
    }

    // Costruttore con data di inizio prestito
    public Prestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30); // Aggiungi 30 giorni
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Libro getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Libro elementoPrestato) { // Utilizzo della classe Libro
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30); // Calcolo automatico della data di restituzione prevista
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
}
