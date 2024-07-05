package alura.foro.api.domain.autor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "autores")
@Entity(name = "Autor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String contraseña;
    private boolean activo;

    public Autor(DatosRegistroAutor autor) {
        //this.id = autor.id();
        this.nombre = autor.nombre();
        this.correo = autor.correo();
        this.contraseña = autor.contraseña();
        this.activo = true;
    }

    public void actualizarDatos(DatosListadoAutor datosListadoAutor) {
        if(datosListadoAutor.nombre() != null){
            this.nombre = datosListadoAutor.nombre();
        }
        if(datosListadoAutor.correo() != null){
            this.correo = datosListadoAutor.correo();
        }
        if(datosListadoAutor.contraseña() != null){
            this.contraseña = datosListadoAutor.contraseña();
        }
    }

    public void desactivarAutor() {
        this.activo = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
