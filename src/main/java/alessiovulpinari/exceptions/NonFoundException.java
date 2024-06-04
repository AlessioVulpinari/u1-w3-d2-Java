package alessiovulpinari.exceptions;

public class NonFoundException extends RuntimeException {
    public NonFoundException(long eventId) {
        System.out.println("Evento con id: " + eventId + " non trovato!");
    }
}
