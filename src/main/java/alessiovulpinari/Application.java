package alessiovulpinari;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u1-w3-d2-Java");

    public static void main(String[] args) {

        System.out.println("Hello world!");

    }
}
