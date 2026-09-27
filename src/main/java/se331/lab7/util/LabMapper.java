package se331.lab7.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab7.entity.Event;
import se331.lab7.entity.EventDTO;
import se331.lab7.entity.Organizer;
import se331.lab7.entity.OrganizerDTO;
import se331.lab7.entity.Participant;
import se331.lab7.entity.ParticipantDTO;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDto(Event event);

    List<EventDTO> getEventDto(List<Event> events);

    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    ParticipantDTO getParticipantDTO(Participant participant);
    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);
}
