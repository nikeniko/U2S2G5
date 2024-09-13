package nicolas.U2S2G5.services;

import jakarta.persistence.EntityNotFoundException;
import nicolas.U2S2G5.entità.Dipendente;
import nicolas.U2S2G5.playloads.*;
import nicolas.U2S2G5.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public void uploadImmagineProfilo(Long dipendenteId, MultipartFile file) throws Exception {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));

        byte[] imageBytes = file.getBytes();
        dipendente.setImmagineProfilo(imageBytes);

        dipendenteRepository.save(dipendente);
    }

    public DipendenteDTO getDipendenteById(Long id) {
        Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));

        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        dipendenteDTO.setId(dipendente.getId());
        dipendenteDTO.setNome(dipendente.getNome());
        dipendenteDTO.setCognome(dipendente.getCognome());
        dipendenteDTO.setEmail(dipendente.getEmail());

        return dipendenteDTO;
    }

    public DipendenteDTO creaDipendente(CreateDipendenteDTO dipendenteDTO) {
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDTO.getNome());
        dipendente.setCognome(dipendenteDTO.getCognome());
        dipendente.setEmail(dipendenteDTO.getEmail());

        Dipendente savedDipendente = dipendenteRepository.save(dipendente);

        DipendenteDTO responseDTO = new DipendenteDTO();
        responseDTO.setId(savedDipendente.getId());
        responseDTO.setNome(savedDipendente.getNome());
        responseDTO.setCognome(savedDipendente.getCognome());
        responseDTO.setEmail(savedDipendente.getEmail());

        return responseDTO;
    }

    public DipendenteDTO aggiornaDipendente(Long id, CreateDipendenteDTO dipendenteDTO) {
        Dipendente dipendenteEsistente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));

        dipendenteEsistente.setNome(dipendenteDTO.getNome());
        dipendenteEsistente.setCognome(dipendenteDTO.getCognome());
        dipendenteEsistente.setEmail(dipendenteDTO.getEmail());

        Dipendente updatedDipendente = dipendenteRepository.save(dipendenteEsistente);

        DipendenteDTO responseDTO = new DipendenteDTO();
        responseDTO.setId(updatedDipendente.getId());
        responseDTO.setNome(updatedDipendente.getNome());
        responseDTO.setCognome(updatedDipendente.getCognome());
        responseDTO.setEmail(updatedDipendente.getEmail());

        return responseDTO;
    }

    public void eliminaDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }
}
