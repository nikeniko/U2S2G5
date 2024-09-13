package nicolas.U2S2G5.controller;

import jakarta.validation.Valid;
import nicolas.U2S2G5.enums.StatoViaggio;
import nicolas.U2S2G5.playloads.CreateViaggioDTO;
import nicolas.U2S2G5.playloads.ViaggioDTO;
import nicolas.U2S2G5.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @PostMapping
    public ResponseEntity<ViaggioDTO> creaViaggio(@RequestBody @Valid CreateViaggioDTO viaggioDTO) {
        return ResponseEntity.ok(viaggioService.creaViaggio(viaggioDTO));
    }

    @PutMapping("/{id}/stato")
    public ResponseEntity<ViaggioDTO> aggiornaStatoViaggio(@PathVariable Long id, @RequestParam String stato) {
        try {
            StatoViaggio statoEnum = StatoViaggio.valueOf(stato.toUpperCase());
            return ResponseEntity.ok(viaggioService.aggiornaStatoViaggio(id, statoEnum));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
