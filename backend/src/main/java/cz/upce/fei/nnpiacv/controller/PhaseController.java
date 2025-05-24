package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.Phase;
import cz.upce.fei.nnpiacv.dto.PhaseRequestDTO;
import cz.upce.fei.nnpiacv.dto.PhaseRespondDTO;
import cz.upce.fei.nnpiacv.service.PhaseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@AllArgsConstructor
public class PhaseController {

    private final PhaseService phaseService;

    @PutMapping("/phases/{id}")
    public PhaseRespondDTO updatePhase(@PathVariable Long id, @Valid @RequestBody PhaseRequestDTO phase) {
        return phaseService.updatePhase(id, phase);
    }

    @PostMapping("/phases")
    public PhaseRespondDTO addPhase(@Valid @RequestBody PhaseRequestDTO phase) {
        return phaseService.addPhase(phase);
    }

    @DeleteMapping("/phases/{id}")
    public PhaseRespondDTO deletePhase(@PathVariable Long id) {
        return phaseService.deletePhase(id);
    }

    @GetMapping("/phases/{id}")
    public PhaseRespondDTO findPhase(@PathVariable Long id) {
        return phaseService.findPhase(id);
    }

    @GetMapping("/phases")
    public Collection<PhaseRespondDTO> getPhases() {
        return phaseService.findPhases();
    }

}
