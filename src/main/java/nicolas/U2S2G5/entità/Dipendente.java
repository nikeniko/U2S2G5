package nicolas.U2S2G5.entità;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cognome;

    private String email;

    @Lob
    private byte[] immagineProfilo;

    @OneToMany(mappedBy = "dipendente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

}
