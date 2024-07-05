package alura.foro.api.infra.errores;

public class ValidacionDeIntegridad extends RuntimeException {

    public ValidacionDeIntegridad(String autorNoExiste) {
        super(autorNoExiste);
    }
}
