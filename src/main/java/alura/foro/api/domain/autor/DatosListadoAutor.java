package alura.foro.api.domain.autor;

public record DatosListadoAutor(
        Long id,
        String nombre,
        String correo,
        String contraseña
) {
    public DatosListadoAutor(Autor autor){
        this(autor.getId(), autor.getNombre(), autor.getCorreo(), autor.getContraseña());
    }
}
