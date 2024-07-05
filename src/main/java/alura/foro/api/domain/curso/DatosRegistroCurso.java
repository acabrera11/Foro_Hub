package alura.foro.api.domain.curso;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        @NotBlank
        @Column(unique=true)
        String nombre,
        @NotBlank
        @Column(unique=true)
        String categoria
) {
}
