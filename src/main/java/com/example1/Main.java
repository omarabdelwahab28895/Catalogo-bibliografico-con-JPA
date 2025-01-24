package com.example1;

import com.example.model.Libro;
import com.example.model.Utente;
import com.example.model.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creazione dell'EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBibliograficoPU");
        EntityManager em = emf.createEntityManager();

        // Creazione di un nuovo libro
        em.getTransaction().begin();

        Libro libro = new Libro();
        libro.setIsbn("1234567890");
        libro.setTitolo("Il Signore degli Anelli");
        libro.setAnnoPubblicazione(1954);
        libro.setNumeroPagine(1200);
        libro.setAutore("J.R.R. Tolkien");
        libro.setGenere("Fantasy");

        Utente utente = new Utente();
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setDataDiNascita(LocalDate.of(1990, 5, 10));
        utente.setNumeroTessera("12345");

        em.persist(utente); // Salva l'utente nel database

        Prestito prestito = new Prestito();
        prestito.setUtente(utente); // Associa l'utente
        prestito.setElementoPrestato(libro); // Associa un libro esistente
        prestito.setDataInizioPrestito(LocalDate.now());

        em.persist(prestito); // Salva il prestito nel database


        em.persist(libro); // Salva il libro nel database
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Libro salvato nel database!");
    }
}
