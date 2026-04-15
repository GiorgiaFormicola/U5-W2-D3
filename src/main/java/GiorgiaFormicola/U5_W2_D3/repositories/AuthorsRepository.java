package GiorgiaFormicola.U5_W2_D3.repositories;

import GiorgiaFormicola.U5_W2_D3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, UUID> {
    boolean existsByEmail(String email);
}
