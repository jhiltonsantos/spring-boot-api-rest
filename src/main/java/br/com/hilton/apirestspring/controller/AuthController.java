package br.com.hilton.apirestspring.controller;

import br.com.hilton.apirestspring.config.security.TokenServices;
import br.com.hilton.apirestspring.controller.dto.TokenDto;
import br.com.hilton.apirestspring.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Profile(value={"prod", "test"})
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenServices tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> auth(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken dataLogin = form.convert();
        try {
            Authentication authenticate = authManager.authenticate(dataLogin);
            String token = tokenService.getToken(authenticate);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
