package alura.foro.api.domain.autor;

public record DatosAutorParcial(Long id,
                                String nombre,
                                String correo) {

    public DatosAutorParcial(Autor autor) {
        this(autor.getId(), autor.getNombre(), autor.getCorreo());
    }
}

