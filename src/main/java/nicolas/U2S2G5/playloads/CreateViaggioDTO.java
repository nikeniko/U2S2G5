package nicolas.U2S2G5.playloads;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateViaggioDTO {
    private String destinazione;
    private LocalDate data;
}
