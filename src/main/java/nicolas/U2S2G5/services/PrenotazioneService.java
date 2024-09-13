package nicolas.U2S2G5.services;

import jakarta.persistence.EntityNotFoundException;
import nicolas.U2S2G5.entità.*;
import nicolas.U2S2G5.playloads.*;
import nicolas.U2S2G5.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    public PrenotazioneDTO assegnaDipendenteAViaggio(Long dipendenteId, Long viaggioId, CreatePrenotazioneDTO prenotazioneDTO) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));

        Viaggio viaggio = viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));

        if (prenotazioneRepository.findByDipendenteAndDataRichiesta(dipendente, prenotazioneDTO.getDataRichiesta()).isEmpty()) {
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setDipendente(dipendente);
            prenotazione.setViaggio(viaggio);
            prenotazione.setDataRichiesta(prenotazioneDTO.getDataRichiesta());
            prenotazione.setNote(prenotazioneDTO.getNote());
            prenotazione.setPreferenza(prenotazioneDTO.getPreferenza());

            Prenotazione savedPrenotazione = prenotazioneRepository.save(prenotazione);
            PrenotazioneDTO prenotazioneResponseDTO = new PrenotazioneDTO();
            prenotazioneResponseDTO.setId(savedPrenotazione.getId());
            prenotazioneResponseDTO.setDataRichiesta(savedPrenotazione.getDataRichiesta());
            prenotazioneResponseDTO.setNote(savedPrenotazione.getNote());
            prenotazioneResponseDTO.setPreferenza(savedPrenotazione.getPreferenza());

            return prenotazioneResponseDTO;
        } else {
            throw new IllegalStateException("Il dipendente ha già una prenotazione per questa data");
        }
    }
}
