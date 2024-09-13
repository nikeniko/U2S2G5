package nicolas.U2S2G5.playloads;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePrenotazioneDTO {
    private LocalDate dataRichiesta;
    private String note;
    private String preferenza;
}