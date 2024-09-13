package nicolas.U2S2G5.playloads;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CreateViaggioDTO {
    @NotBlank(message = "La destinazione è obbligatoria")
    @Size(max = 100, message = "La destinazione può contenere al massimo 100 caratteri")
    private String destinazione;

    @NotNull(message = "La data è obbligatoria")
    private LocalDate data;
}
