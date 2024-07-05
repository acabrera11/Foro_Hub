package alura.foro.api.controller;


import alura.foro.api.domain.autor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public void registrarAutor(@RequestBody @Valid DatosRegistroAutor datosRegistroAutor) {
        autorRepository.save(new Autor(datosRegistroAutor));
    }

    @GetMapping
    public Page<DatosAutorParcial> listadoUsuarios(@PageableDefault(size = 10) Pageable paginacion) {
        //return autorRepository.findAll(paginacion).map(DatosListadoAutor::new);
        return autorRepository.findAllByActivoTrue(paginacion).map(DatosAutorParcial::new);
    }

    @PutMapping
    @Transactional
    public void actualizarAutor(@RequestBody @Valid DatosListadoAutor datosListadoAutor){
        Autor autor = autorRepository.getReferenceById(datosListadoAutor.id());
        autor.actualizarDatos(datosListadoAutor);
    }

    //Borrar Autor de la BD
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void eliminarMedico(@PathVariable Long id){
//        Autor autor = autorRepository.getReferenceById(id);
//        autorRepository.delete(autor);
//    }

    //Borrado lógico
        @DeleteMapping("/{id}")
        @Transactional
        public void eliminarAutor(@PathVariable Long id){
        Autor autor = autorRepository.getReferenceById(id);
        autor.desactivarAutor();
    }
}
