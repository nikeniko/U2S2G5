package nicolas.U2S2G5.controller;

import nicolas.U2S2G5.playloads.CreateDipendenteDTO;
import nicolas.U2S2G5.playloads.CreatePrenotazioneDTO;
import nicolas.U2S2G5.playloads.DipendenteDTO;
import nicolas.U2S2G5.playloads.PrenotazioneDTO;
import nicolas.U2S2G5.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("/{id}")
    public ResponseEntity<DipendenteDTO> getDipendenteById(@PathVariable Long id) {
        return ResponseEntity.ok(dipendenteService.getDipendenteById(id));
    }

    @PostMapping
    public ResponseEntity<DipendenteDTO> creaDipendente(@RequestBody CreateDipendenteDTO dipendenteDTO) {
        return ResponseEntity.ok(dipendenteService.creaDipendente(dipendenteDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DipendenteDTO> aggiornaDipendente(@PathVariable Long id, @RequestBody CreateDipendenteDTO dipendenteDTO) {
        return ResponseEntity.ok(dipendenteService.aggiornaDipendente(id, dipendenteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaDipendente(@PathVariable Long id) {
        dipendenteService.eliminaDipendente(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{dipendenteId}/viaggi/{viaggioId}")
    public ResponseEntity<PrenotazioneDTO> assegnaDipendenteAViaggio(
            @PathVariable Long dipendenteId,
            @PathVariable Long viaggioId,
            @RequestBody CreatePrenotazioneDTO prenotazioneDTO) {
        return ResponseEntity.ok(prenotazioneService.assegnaDipendenteAViaggio(dipendenteId, viaggioId, prenotazioneDTO));
    }

    @PostMapping("/{dipendenteId}/uploadImmagine")
    public ResponseEntity<String> uploadImmagineProfilo(@PathVariable Long dipendenteId, @RequestParam("file") MultipartFile file) {
        try {
            dipendenteService.uploadImmagineProfilo(dipendenteId, file);
            return ResponseEntity.ok("Immagine caricata con successo.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante il caricamento dell'immagine.");
        }
    }
}
