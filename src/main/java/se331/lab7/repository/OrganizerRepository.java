package se331.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab7.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
