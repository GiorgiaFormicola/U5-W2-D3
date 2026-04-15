package GiorgiaFormicola.U5_W2_D3.controllers;

import GiorgiaFormicola.U5_W2_D3.entities.Author;
import GiorgiaFormicola.U5_W2_D3.payloads.AuthorPayload;
import GiorgiaFormicola.U5_W2_D3.services.AuthorsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorsController {
    private AuthorsService authorsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody AuthorPayload body) {
        return this.authorsService.saveAuthor(body);
    }

}
