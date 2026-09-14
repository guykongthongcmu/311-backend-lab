package se331.lab7.dao;

import org.springframework.data.domain.Page;
import se331.lab7.entity.Organizer;

import java.util.List;

public interface OrganizerDao {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizer(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer organizer);
}
