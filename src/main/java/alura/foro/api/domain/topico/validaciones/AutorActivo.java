package alura.foro.api.domain.topico.validaciones;

import alura.foro.api.domain.autor.AutorRepository;
import alura.foro.api.domain.topico.DatosRegistroTopico;
import jakarta.validation.ValidationException;

public class AutorActivo {

    private AutorRepository repository;

    public void validar(DatosRegistroTopico datos){
        if(datos.idAutor()==null){
            return;
        }
        var autorActivo = repository.findActivoById(datos.idAutor());

        if(!autorActivo){
            throw new ValidationException("Usuario inactivo: No se puede permitir postear en el foro");
        }
    }
}
