package nicolas.U2S2G5.entità;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import nicolas.U2S2G5.enums.StatoViaggio;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinazione;

    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;

    private LocalDate data;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "viaggio_id")
    private List<Prenotazione> prenotazioni;
}
