package GiorgiaFormicola.U5_W2_D3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorPayload {
    private String message;
    private LocalDateTime timestamp;
}
