package fiap.com.br.fiap.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fiap.com.br.fiap.model.Profile;
import fiap.com.br.fiap.repository.ProfileRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProfileRepository repository;

    // Listar todos os perfis
    @GetMapping
    @Cacheable("profiles")
    public List<Profile> listarPerfis() {
        return repository.findAll();
    }

    // Criar um novo perfil
    @PostMapping
    @CacheEvict(value = "profiles", allEntries = true)
    public ResponseEntity<Profile> criarPerfil(@RequestBody @Valid Profile profile) {
        log.info("Cadastrando perfil: " + profile.getName());
        Profile novoPerfil = repository.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPerfil);
    }

    // Buscar por ID
    @GetMapping("{id}")
    public Profile buscarPerfil(@PathVariable Long id) {
        log.info("Buscando perfil " + id);
        return getPerfil(id);
    }

    // Atualizar perfil
    @PutMapping("{id}")
    @CacheEvict(value = "profiles", allEntries = true)
    public Profile atualizarPerfil(@PathVariable Long id, @RequestBody @Valid Profile profile) {
        log.info("Atualizando perfil " + id + " para " + profile);
        profile.setId(id);
        return repository.save(profile);
    }

    // Remover perfil
    @DeleteMapping("{id}")
    @CacheEvict(value = "profiles", allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPerfil(@PathVariable Long id) {
        log.info("Apagando perfil " + id);
        repository.delete(getPerfil(id));
    }

    // Método auxiliar para buscar perfil com tratamento de erro
    private Profile getPerfil(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado"));
    }
}
