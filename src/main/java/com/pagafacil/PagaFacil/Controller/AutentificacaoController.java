package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Cliente.Cliente;
import com.pagafacil.PagaFacil.Dominio.Cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

public class AutentificacaoController {

    @RestController
    @RequestMapping("autentificacao")
    public class AuthController {

        @Autowired
        private ClienteRepository clienteRepository;

        @PostMapping("/login")
        public ResponseEntity<String> login(@RequestParam String username, @RequestParam String senha) {
            Cliente cliente = (Cliente) clienteRepository.findByCpfOrEmail(username, username)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não encontrado ou credenciais inválidas"));

            if (!cliente.getSenha().equals(senha)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Senha incorreta");
            }

            // Gerar token de sessão ou JWT se precisar de autenticação avançada
            // Aqui vamos retornar apenas uma mensagem simples de sucesso por enquanto

            return ResponseEntity.ok("Login bem-sucedido!");
        }
    }


}
