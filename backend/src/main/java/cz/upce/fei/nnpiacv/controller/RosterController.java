package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.Roster;
import cz.upce.fei.nnpiacv.dto.RosterRespondDTO;
import cz.upce.fei.nnpiacv.service.RosterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class RosterController {

    private final RosterService rosterService;

    @PostMapping("/events/{eventId}/racers/{racerId}/rosters")
    public RosterRespondDTO addRoster(@PathVariable Long eventId, @PathVariable Long racerId) {
        return rosterService.addRoster(eventId, racerId);
    }

    @GetMapping("/events/{eventId}/racers/{racerId}/rosters")
    public RosterRespondDTO findRoster(@PathVariable Long eventId, @PathVariable Long racerId) {
        return rosterService.findRoster(eventId, racerId);
    }

    @DeleteMapping("/events/{eventId}/racers/{racerId}/rosters")
    public RosterRespondDTO deleteRoster(@PathVariable Long eventId, @PathVariable Long racerId) {
        return rosterService.deleteRoster(eventId, racerId);
    }

    @GetMapping("/rosters")
    public Collection<RosterRespondDTO> getRosters() {
        return rosterService.findRosters();
    }

}
