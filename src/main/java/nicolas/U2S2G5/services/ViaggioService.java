package nicolas.U2S2G5.services;



import nicolas.U2S2G5.entità.Viaggio;
import nicolas.U2S2G5.enums.StatoViaggio;
import nicolas.U2S2G5.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public Viaggio creaViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public Viaggio aggiornaStatoViaggio(Long id, StatoViaggio stato) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));
        viaggio.setStato(stato);
        return viaggioRepository.save(viaggio);
    }
}
