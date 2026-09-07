package se331.lab7.service;

import se331.lab7.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrganizerSize();
    List<Organizer> getOrganizer(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
}
