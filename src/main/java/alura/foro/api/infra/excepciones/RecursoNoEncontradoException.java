package alura.foro.api.infra.excepciones;

public class RecursoNoEncontradoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
