package GiorgiaFormicola.U5_W2_D3.services;

import GiorgiaFormicola.U5_W2_D3.repositories.AuthorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorsService {
    private AuthorsRepository authorsRepository;
}
