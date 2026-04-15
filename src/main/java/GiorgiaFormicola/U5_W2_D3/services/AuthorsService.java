package GiorgiaFormicola.U5_W2_D3.services;

import GiorgiaFormicola.U5_W2_D3.entities.Author;
import GiorgiaFormicola.U5_W2_D3.exceptions.BadRequestException;
import GiorgiaFormicola.U5_W2_D3.payloads.AuthorPayload;
import GiorgiaFormicola.U5_W2_D3.repositories.AuthorsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AuthorsService {
    private AuthorsRepository authorsRepository;

    public Author saveAuthor(AuthorPayload body) {
        if (this.authorsRepository.existsByEmail(body.getEmail()))
            throw new BadRequestException("Email address " + body.getEmail() + " already in use!");
        Author newAuthor = new Author(body.getName(), body.getSurname(), body.getEmail(), body.getBirthDate());
        Author savedAuthor = authorsRepository.save(newAuthor);
        log.info("Author with id " + savedAuthor.getId() + " successfully saved");
        return savedAuthor;
    }
}
