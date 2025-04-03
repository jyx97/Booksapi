package fiap.com.br.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.fiap.model.Profile;
import fiap.com.br.fiap.repository.ProfileRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository repository;

    // Listar todos os perfis
    @GetMapping
    public List<Profile> listarPerfis() {
        return repository.findAll();
    } 

    // Criar um novo perfil
    @PostMapping
    public ResponseEntity<Profile> criarPerfil(@RequestBody @Valid Profile profile) {
        Profile novoPerfil = repository.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPerfil);
    }
    
}
