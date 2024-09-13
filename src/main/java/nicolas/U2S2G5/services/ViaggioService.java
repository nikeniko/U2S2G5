package nicolas.U2S2G5.services;

import jakarta.persistence.EntityNotFoundException;
import nicolas.U2S2G5.entità.Viaggio;
import nicolas.U2S2G5.enums.StatoViaggio;
import nicolas.U2S2G5.playloads.*;
import nicolas.U2S2G5.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public ViaggioDTO creaViaggio(CreateViaggioDTO viaggioDTO) {
        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(viaggioDTO.getDestinazione());
        viaggio.setData(viaggioDTO.getData());
        viaggio.setStato(StatoViaggio.IN_PROGRAMMA);

        Viaggio savedViaggio = viaggioRepository.save(viaggio);

        ViaggioDTO viaggioResponseDTO = new ViaggioDTO();
        viaggioResponseDTO.setId(savedViaggio.getId());
        viaggioResponseDTO.setDestinazione(savedViaggio.getDestinazione());
        viaggioResponseDTO.setData(savedViaggio.getData());
        viaggioResponseDTO.setStato(savedViaggio.getStato());

        return viaggioResponseDTO;
    }

    public ViaggioDTO aggiornaStatoViaggio(Long id, StatoViaggio stato) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));

        viaggio.setStato(stato);

        Viaggio updatedViaggio = viaggioRepository.save(viaggio);

        ViaggioDTO viaggioResponseDTO = new ViaggioDTO();
        viaggioResponseDTO.setId(updatedViaggio.getId());
        viaggioResponseDTO.setDestinazione(updatedViaggio.getDestinazione());
        viaggioResponseDTO.setData(updatedViaggio.getData());
        viaggioResponseDTO.setStato(updatedViaggio.getStato());

        return viaggioResponseDTO;
    }
}
