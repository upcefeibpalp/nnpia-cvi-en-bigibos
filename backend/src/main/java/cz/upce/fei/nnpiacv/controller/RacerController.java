package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.Racer;
import cz.upce.fei.nnpiacv.dto.RacerRequestDTO;
import cz.upce.fei.nnpiacv.dto.RacerRespondDTO;
import cz.upce.fei.nnpiacv.service.RacerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@AllArgsConstructor
public class RacerController {

    private final RacerService racerService;

    @PutMapping("/racers/{id}")
    public RacerRespondDTO updateRacer(@PathVariable Long id, @Valid @RequestBody RacerRequestDTO racer) {
        return racerService.updateRacer(id, racer);
    }

    @PutMapping("/racers/{racerId}/teams/{teamId}")
    public RacerRespondDTO assignTeam(@PathVariable Long racerId, @PathVariable Long teamId) {
        return racerService.assignTeam(racerId, teamId);
    }

    @PutMapping("/racers/{racerId}/cars/{carId}")
    public RacerRespondDTO assignCar(@PathVariable Long racerId, @PathVariable Long carId) {
        return racerService.assignCar(racerId, carId);
    }

    @PostMapping("/racers")
    public RacerRespondDTO addRacer(@Valid @RequestBody RacerRequestDTO racer) {
        return racerService.addRacer(racer);
    }

    @DeleteMapping("/racers/{id}")
    public RacerRespondDTO deleteRacer(@PathVariable Long id) {
        return racerService.deleteRacer(id);
    }

    @DeleteMapping("/racers/{racerId}/teams")
    public RacerRespondDTO removeTeam(@PathVariable Long racerId) {
        return racerService.removeTeam(racerId);
    }

    @DeleteMapping("/racers/{racerId}/cars")
    public RacerRespondDTO removeCar(@PathVariable Long racerId) {
        return racerService.removeCar(racerId);
    }

    @GetMapping("/racers")
    public Collection<RacerRespondDTO> getRacers() {
        return racerService.findRacers();
    }

    @GetMapping("/racers/{id}")
    public RacerRespondDTO findRacer(@PathVariable Long id) {
        return racerService.findRacer(id);
    }

}
