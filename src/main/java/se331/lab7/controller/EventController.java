package se331.lab7.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se331.lab7.entity.Event;

import se331.lab7.entity.Organizer;
import se331.lab7.service.EventService;
import se331.lab7.service.OrganizerService;
import se331.lab7.service.OrganizerServiceImpl;

import java.util.List;

@RestController
public class EventController {

    final EventService eventService;
    final OrganizerService organizerService;

    public EventController(EventService eventService, OrganizerService organizerService) {
        this.eventService = eventService;
        this.organizerService = organizerService;
    }

    @GetMapping("/events")
    public ResponseEntity<?> getEventList(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page) {
        List<Event> output = null;
        Integer eventSize = eventService.getEventSize();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(eventSize));
        try {
            output = eventService.getEvents(perPage, page);
            return ResponseEntity.ok().headers(responseHeader).body(output);
        } catch (IndexOutOfBoundsException ex) {
            return ResponseEntity.ok().headers(responseHeader).body(output);
        }
    }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Event output = eventService.getEvent(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @GetMapping("organizer/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id) {
        Organizer output = organizerService.getOrganizer(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
