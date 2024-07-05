package alura.foro.api.domain.topico;

import alura.foro.api.domain.autor.AutorRepository;
import alura.foro.api.domain.curso.CursoRepository;
import alura.foro.api.infra.errores.ValidacionDeIntegridad;
import alura.foro.api.infra.excepciones.RecursoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarTopicoService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosListadoTopico registrarTopico(DatosRegistroTopico datos){

        if(!autorRepository.findById(datos.idCurso()).isPresent()){
            throw new ValidacionDeIntegridad("Curso no existe");
        }

        if(datos.idAutor()!=null && !autorRepository.existsById(datos.idAutor())){
            throw new ValidacionDeIntegridad("Autor no existe");
        }

        var autor = autorRepository.findById(datos.idAutor()).get();
        var curso = cursoRepository.findById(datos.idCurso()).get();

        var topico = new Topico(null, datos.titulo(), datos.mensaje(), datos.fechaCreacion(), datos.status(),
                autor, curso);

        topicoRepository.save(topico);

        return new DatosListadoTopico(topico);
    }

    public DatosListadoTopico encontrarPublicacionPorId(Long publicacionId) {
        if(!topicoRepository.existsById(publicacionId)) {
            throw new RecursoNoEncontradoException("No fue posible encontrar la publicación de id: " + publicacionId);
        }

        Topico topico = topicoRepository.getReferenceById(publicacionId);
        return new DatosListadoTopico(topico);
    }

}
