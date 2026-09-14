package se331.lab7.service;

import org.springframework.data.domain.Page;
import se331.lab7.entity.Organizer;

public interface OrganizerService {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizer(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer organizer);
}
