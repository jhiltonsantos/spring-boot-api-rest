package br.com.hilton.apirestspring.config.security;

import br.com.hilton.apirestspring.models.User;
import br.com.hilton.apirestspring.repository.IUserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {

    private TokenServices tokenServices;
    private IUserRepository userRepository;

    public AuthTokenFilter(TokenServices tokenService, IUserRepository userRepository) {
        this.tokenServices = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = recoverToken(request);
        boolean valid = tokenServices.isValidToken(token);
        if (valid) {
            authClient(token);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization");
        if (authToken == null || authToken.isEmpty() || !authToken.startsWith("Bearer ")) {
            return null;
        }
        return authToken.substring(7, authToken.length());

    }

    private void authClient(String token) {
        Long idUser = tokenServices.getIdUser(token);
        User user = userRepository.findById(idUser).get();
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
