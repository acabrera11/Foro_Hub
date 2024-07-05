package alura.foro.api.controller;

import alura.foro.api.domain.autor.DatosListadoAutor;
import alura.foro.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistrarTopicoService service;

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        var respuesta = service.registrarTopico(datosRegistroTopico);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size = 10, sort = {"fechaCreacion"},
            direction = Sort.Direction.DESC) Pageable paginacion) {
        return repository.findAllByStatusTrue(paginacion).map(DatosListadoTopico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> listarTopicoPorId(@PathVariable Long id) {
        DatosListadoTopico topico = service.encontrarPublicacionPorId(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = repository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatosTopico(datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    //BORRADO EN BD
//    public void eliminarTopico(@PathVariable Long id){
//        Topico topico = repository.getReferenceById(id);
//        repository.delete(topico);
//    }
    //BORRADO LOGICO
        public void eliminarTopico(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);
        topico.desactivarTopico();
    }


}
