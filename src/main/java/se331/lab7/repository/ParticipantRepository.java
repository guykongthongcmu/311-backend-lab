package se331.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab7.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
