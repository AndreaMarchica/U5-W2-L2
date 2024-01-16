package andreamarchica.U5W2L2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Elemento con id " + id + " non trovato!");
    }
}