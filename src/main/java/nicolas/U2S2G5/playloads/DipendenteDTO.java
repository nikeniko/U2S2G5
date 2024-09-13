package nicolas.U2S2G5.playloads;

import lombok.Data;

import java.util.List;

@Data
public class DipendenteDTO {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private List<PrenotazioneDTO> prenotazioni;
}
