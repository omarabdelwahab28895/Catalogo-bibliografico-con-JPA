package com.example1;

import com.example.model.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

        em.persist(libro); // Salva il libro nel database
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Libro salvato nel database!");
    }
}
