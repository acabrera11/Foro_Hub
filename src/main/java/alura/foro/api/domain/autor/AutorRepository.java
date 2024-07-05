package alura.foro.api.domain.autor;

import alura.foro.api.domain.topico.DatosRegistroTopico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    UserDetails findByCorreo(String correo);

    Page<Autor> findAllByActivoTrue(Pageable paginacion);
    //findByActivoTrue(Pageable paginacion);
    @Query("""
            select p.activo
            from Autor p
            where p.id=:idAutor 
            """)
    Boolean findActivoById(Long idAutor);

}
