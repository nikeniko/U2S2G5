package nicolas.U2S2G5.playloads;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class CreateDipendenteDTO {
    @NotBlank(message = "Il nome è obbligatorio")
    @Size(max = 50, message = "Il nome può contenere al massimo 50 caratteri")
    private String nome;

    @NotBlank(message = "Il cognome è obbligatorio")
    @Size(max = 50, message = "Il cognome può contenere al massimo 50 caratteri")
    private String cognome;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "L'email deve essere valida")
    private String email;
}
