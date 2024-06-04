package alessiovulpinari;

import alessiovulpinari.dao.EventoDao;
import alessiovulpinari.entities.EventType;
import alessiovulpinari.entities.Evento;
import alessiovulpinari.exceptions.NonFoundException;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u1-w3-d2-Java");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EventoDao eventoDao = new EventoDao(entityManager);

//        for (int i = 0; i < 20; i++) {
//            Evento evento = CreateEvent();
//
//            eventoDao.save(evento);
//        }


        try {
            eventoDao.deleteEventById(121L);
        } catch (NonFoundException exception) {
            System.out.println(exception.getMessage());
        }
        
        try {
            Evento searchEvent = eventoDao.getEventById(120L);
            System.out.println(searchEvent);
        } catch (NonFoundException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static Evento CreateEvent() {

        Supplier<Evento> eventSupplier = () -> {
            Faker faker = new Faker();
            Random random = new Random();
            EventType[] eventType = {EventType.PRIVATE, EventType.PUBBLIC};
            return new Evento(faker.artist().name(), LocalDate.now().minusDays(random.nextInt(0, 40)),
                    faker.ancient().primordial(), eventType[random.nextInt(2)],
                    random.nextInt(1000, 5200000));
        };

        return eventSupplier.get();
    }
}
