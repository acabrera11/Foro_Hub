package alura.foro.api.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        boolean status,
        Long idAutor,
        Long idCurso
) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.isStatus(),topico.getAutor().getId(), topico.getCurso().getId());
    }
}
