package se331.lab7.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab7.entity.Event;
import se331.lab7.entity.Organizer;
import se331.lab7.entity.Participant;
import se331.lab7.repository.EventRepository;
import se331.lab7.repository.OrganizerRepository;
import se331.lab7.repository.ParticipantRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                        .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                        .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                        .name("ChiangMai").build());
        Event event1, event2, event3, event4;
        event1 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petsAllowed(false)
                        .build());
        event1.setOrganizer(org1);
        org1.getOwnEvents().add(event1);
        eventRepository.save(event1);
        event2 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petsAllowed(false)
                .build());
        event2.setOrganizer(org1);
        org1.getOwnEvents().add(event2);
        eventRepository.save(event2);
        event3 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petsAllowed(false)
                .build());
        event3.setOrganizer(org2);
        org2.getOwnEvents().add(event3);
        eventRepository.save(event3);
        event4 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petsAllowed(true)
                .build());
        event4.setOrganizer(org3);
        org3.getOwnEvents().add(event4);
        eventRepository.save(event4);

        participantRepository.save(Participant.builder()
                .name("Alice Somsri")
                .telNo("081-111-1111")
                .eventHistories(List.of(event1, event2, event3))
                .build());
        participantRepository.save(Participant.builder()
                .name("Bob Jaidee")
                .telNo("082-222-2222")
                .eventHistories(List.of(event2, event3, event4))
                .build());
        participantRepository.save(Participant.builder()
                .name("Carol Rakthai")
                .telNo("083-333-3333")
                .eventHistories(List.of(event1, event3, event4))
                .build());
        participantRepository.save(Participant.builder()
                .name("Dave Suksan")
                .telNo("084-444-4444")
                .eventHistories(List.of(event1, event4))
                .build());
        participantRepository.save(Participant.builder()
                .name("Eve Boonmee")
                .telNo("085-555-5555")
                .eventHistories(List.of(event2))
                .build());
    }
}
