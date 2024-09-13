package nicolas.U2S2G5.playloads;

import lombok.Data;
import nicolas.U2S2G5.enums.StatoViaggio;

import java.time.LocalDate;
import java.util.List;

@Data
public class ViaggioDTO {
    private Long id;
    private String destinazione;
    private StatoViaggio stato;
    private LocalDate data;
    private List<PrenotazioneDTO> prenotazioni;
}
