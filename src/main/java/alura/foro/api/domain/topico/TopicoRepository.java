package alura.foro.api.domain.topico;

import alura.foro.api.domain.autor.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByStatusTrue(Pageable paginacion);
    //Page<Topico> findAllByActivoTrue(Pageable paginacion);
}
