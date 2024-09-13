package nicolas.U2S2G5.playloads;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CreatePrenotazioneDTO {
    @NotNull(message = "La data richiesta è obbligatoria")
    private LocalDate dataRichiesta;

    @Size(max = 200, message = "Le note possono contenere al massimo 200 caratteri")
    private String note;

    @Size(max = 50, message = "La preferenza può contenere al massimo 50 caratteri")
    private String preferenza;
}
