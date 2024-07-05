package alura.foro.api.controller;

import alura.foro.api.domain.curso.Curso;
import alura.foro.api.domain.curso.CursoRepository;
import alura.foro.api.domain.curso.DatosRegistroCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public void registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso){
        cursoRepository.save(new Curso(datosRegistroCurso));
    }
}
