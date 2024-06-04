package alessiovulpinari.dao;

import alessiovulpinari.entities.Evento;
import alessiovulpinari.exceptions.NonFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDao {

    private final EntityManager entityManager;

    public EventoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento event) {
        // Aprire la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Iniziare la transazione
        transaction.begin();

        // Aggiungere al persist Context
        entityManager.persist(event);

        // Chiudere la transazione, salvando nel db
        transaction.commit();
        System.out.println("Evento: " + event.getDescription() + " è stato aggiunto correttamente al db!");
    }

    public Evento getEventById(Long eventId) {
        Evento event = entityManager.find(Evento.class, eventId);

        if (event == null) throw new NonFoundException(eventId);

        return event;
    }

    public void deleteEventById(Long eventId) {
        // Cerchiamo l'evento
        Evento foundEvent = getEventById(eventId);

        // Creo la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // Inizializzo la transazione
        transaction.begin();

        // Rimuovo l'evento
        entityManager.remove(foundEvent);

        // Chiudo la transazione e salvo il cambiamento
        transaction.commit();

        System.out.println("Evento: " + foundEvent.getDescription() + " è stato eliminato correttamente al db!");
    }
}
