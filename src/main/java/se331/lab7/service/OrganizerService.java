package se331.lab7.service;

import org.springframework.data.domain.Page;
import se331.lab7.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    List<Organizer> getAllOrganizer();
    Page<Organizer> getOrganizer(Integer page, Integer pageSize);
}
