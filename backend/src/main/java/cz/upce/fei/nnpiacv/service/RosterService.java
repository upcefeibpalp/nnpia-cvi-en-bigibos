package cz.upce.fei.nnpiacv.service;

import cz.upce.fei.nnpiacv.domain.Event;
import cz.upce.fei.nnpiacv.domain.Racer;
import cz.upce.fei.nnpiacv.domain.Roster;
import cz.upce.fei.nnpiacv.dto.RosterRespondDTO;
import cz.upce.fei.nnpiacv.dto.TeamRespondDTO;
import cz.upce.fei.nnpiacv.id.RosterId;
import cz.upce.fei.nnpiacv.repository.EventRepository;
import cz.upce.fei.nnpiacv.repository.RacerRepository;
import cz.upce.fei.nnpiacv.repository.RosterRepository;
import cz.upce.fei.nnpiacv.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class RosterService {

    private final RosterRepository rosterRepository;
    private final EventRepository eventRepository;
    private final RacerRepository racerRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public RosterRespondDTO addRoster(Long eventId, Long racerId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event with ID " + eventId + " not found"));

        Racer racer = racerRepository.findById(racerId)
                .orElseThrow(() -> new EntityNotFoundException("Racer with ID " + racerId + " not found"));

        Roster roster = new Roster();
        roster.setId(new RosterId(eventId, racerId));
        roster.setEvent(event);
        roster.setRacer(racer);

        rosterRepository.save(roster);

        return modelMapper.map(roster, RosterRespondDTO.class);
    }

    @Transactional
    public RosterRespondDTO deleteRoster(Long eventId, Long racerId) {
        RosterId id = new RosterId(eventId, racerId);
        Roster roster = rosterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Roster not found for event " + eventId + " and racer " + racerId));

        rosterRepository.deleteById(roster.getId());

        return modelMapper.map(roster, RosterRespondDTO.class);
    }

    public Collection<RosterRespondDTO> findRosters() {
        return rosterRepository.findAll().stream()
                .map(team -> modelMapper.map(team, RosterRespondDTO.class))
                .collect(Collectors.toList());
    }

    public RosterRespondDTO findRoster(Long eventId, Long racerId) {
        RosterId id = new RosterId(eventId, racerId);
        Roster roster = rosterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Roster not found for event " + eventId + " and racer " + racerId));

        return modelMapper.map(roster, RosterRespondDTO.class);
    }

}
