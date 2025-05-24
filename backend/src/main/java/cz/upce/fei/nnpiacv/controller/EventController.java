package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.Event;
import cz.upce.fei.nnpiacv.dto.EventRequestDTO;
import cz.upce.fei.nnpiacv.dto.EventRespondDTO;
import cz.upce.fei.nnpiacv.service.EventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @PutMapping("/events/{id}")
    public EventRespondDTO updateEvent(@PathVariable Long id, @Valid @RequestBody EventRequestDTO event) {
        return eventService.updateEvent(id, event);
    }

    @PostMapping("/events")
    public EventRespondDTO addEvent(@Valid @RequestBody EventRequestDTO event) {
        return eventService.addEvent(event);
    }

    @DeleteMapping("/events/{id}")
    public EventRespondDTO deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }

    @GetMapping("/events/{id}")
    public EventRespondDTO findEvent(@PathVariable Long id) {
        return eventService.findEvent(id);
    }

    @GetMapping("/events")
    public Collection<EventRespondDTO> getEvents() {
        return eventService.findEvents();
    }

}
