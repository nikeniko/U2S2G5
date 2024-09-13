package nicolas.U2S2G5.services;

import nicolas.U2S2G5.entità.Prenotazione;
import nicolas.U2S2G5.entità.Dipendente;
import nicolas.U2S2G5.entità.Viaggio;
import nicolas.U2S2G5.repository.PrenotazioneRepository;
import nicolas.U2S2G5.repository.DipendenteRepository;
import nicolas.U2S2G5.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    public Prenotazione assegnaDipendenteAViaggio(Long dipendenteId, Long viaggioId, Prenotazione prenotazione) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));

        Viaggio viaggio = viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));

        if (prenotazioneRepository.findByDipendenteAndDataRichiesta(dipendente, prenotazione.getDataRichiesta()).isEmpty()) {
            prenotazione.setDipendente(dipendente);
            prenotazione.setViaggio(viaggio);
            return prenotazioneRepository.save(prenotazione);
        } else {
            throw new IllegalStateException("Il dipendente ha già una prenotazione per questa data");
        }
    }
}
