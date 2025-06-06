package br.ifsp.edu.br.Avaliacao02.util.security;

import br.ifsp.edu.br.Avaliacao02.usuario.Usuario;
import br.ifsp.edu.br.Avaliacao02.usuario.dadosAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private PW3TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(
            @RequestBody @Valid dadosAutenticacao dados
    ) {
        var authToken = new UsernamePasswordAuthenticationToken(
                dados.login(),
                dados.senha()
        );
        var authentication = manager.authenticate(authToken);
        var usuarioAutenticado = (Usuario) authentication.getPrincipal();
        String tokenJWT = tokenService.gerarToken(usuarioAutenticado);
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}