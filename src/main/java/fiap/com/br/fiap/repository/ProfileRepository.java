package fiap.com.br.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.fiap.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}
