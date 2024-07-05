package alura.foro.api.infra.security;

import alura.foro.api.domain.autor.AutorRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AutorRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("Filtro llamado");
        // Obtener el token del header
        var authHeader = request.getHeader("Authorization");

        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var usuarioCorreo = tokenService.getSubject(token); // se extrae el usuario que en este caso es el correo electronico, para ver si el usuario tiene sesion

            if (usuarioCorreo != null) {
                // Si el Token es valido forzo un inicio de sesion, lo hago con usuarioRepository
                var usuario = usuarioRepository.findByCorreo(usuarioCorreo);
                //transformmo usuario a objeto de authentication
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities()); // Forzamos un inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            System.out.println(usuarioCorreo);
        }
        filterChain.doFilter(request, response);
    }
}
