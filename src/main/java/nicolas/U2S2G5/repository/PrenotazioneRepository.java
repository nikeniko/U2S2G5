package nicolas.U2S2G5.repository;

import nicolas.U2S2G5.entità.Prenotazione;
import nicolas.U2S2G5.entità.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);
}