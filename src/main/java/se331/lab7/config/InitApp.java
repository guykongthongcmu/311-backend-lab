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

        Event event5, event6, event7, event8, event9, event10, event11, event12, event13, event14;
        event5 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Final Exam")
                .description("A time for taking the final exam")
                .location("CAMT Building")
                .date("15th Dec")
                .time("9.00-12.00 am.")
                .petsAllowed(false)
                .build());
        event5.setOrganizer(org1);
        org1.getOwnEvents().add(event5);
        eventRepository.save(event5);

        event6 = eventRepository.save(Event.builder()
                .category("Workshop")
                .title("AI Workshop")
                .description("Hands-on session on machine learning")
                .location("CAMT Building")
                .date("10th Oct")
                .time("1.00-4.00 pm.")
                .petsAllowed(false)
                .build());
        event6.setOrganizer(org1);
        org1.getOwnEvents().add(event6);
        eventRepository.save(event6);

        event7 = eventRepository.save(Event.builder()
                .category("Sports")
                .title("CMU Sports Day")
                .description("Annual sports competition")
                .location("CMU Stadium")
                .date("5th Feb")
                .time("8.00am-5.00 pm.")
                .petsAllowed(false)
                .build());
        event7.setOrganizer(org2);
        org2.getOwnEvents().add(event7);
        eventRepository.save(event7);

        event8 = eventRepository.save(Event.builder()
                .category("Career")
                .title("CMU Job Fair")
                .description("Meet companies hiring for internships and jobs")
                .location("CMU Convention hall")
                .date("18th Mar")
                .time("9.00am-4.00 pm.")
                .petsAllowed(false)
                .build());
        event8.setOrganizer(org2);
        org2.getOwnEvents().add(event8);
        eventRepository.save(event8);

        event9 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Yi Peng Lantern Festival")
                .description("A time for releasing lanterns")
                .location("Ping River")
                .date("15th Nov")
                .time("6.00-9.00 pm.")
                .petsAllowed(false)
                .build());
        event9.setOrganizer(org2);
        org2.getOwnEvents().add(event9);
        eventRepository.save(event9);

        event10 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Chiang Mai Flower Festival")
                .description("A time for flower parade")
                .location("Chiang Mai Moat")
                .date("1st Feb")
                .time("8.00am-6.00 pm.")
                .petsAllowed(true)
                .build());
        event10.setOrganizer(org3);
        org3.getOwnEvents().add(event10);
        eventRepository.save(event10);

        event11 = eventRepository.save(Event.builder()
                .category("Market")
                .title("Chiang Mai Night Market")
                .description("A time for shopping local crafts")
                .location("Chiang Mai Night Bazaar")
                .date("Every Fri-Sun")
                .time("6.00-11.00 pm.")
                .petsAllowed(true)
                .build());
        event11.setOrganizer(org3);
        org3.getOwnEvents().add(event11);
        eventRepository.save(event11);

        event12 = eventRepository.save(Event.builder()
                .category("Music")
                .title("Chiang Mai Music Festival")
                .description("Live music from local bands")
                .location("Chiang Mai Moat")
                .date("22nd Jun")
                .time("5.00-10.00 pm.")
                .petsAllowed(true)
                .build());
        event12.setOrganizer(org3);
        org3.getOwnEvents().add(event12);
        eventRepository.save(event12);

        event13 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Open House")
                .description("A time for prospective students to visit CAMT")
                .location("CAMT Building")
                .date("20th Aug")
                .time("9.00am-3.00 pm.")
                .petsAllowed(false)
                .build());
        event13.setOrganizer(org1);
        org1.getOwnEvents().add(event13);
        eventRepository.save(event13);

        event14 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("New Year Countdown")
                .description("A time for celebrating the new year")
                .location("CMU Convention hall")
                .date("31st Dec")
                .time("9.00pm-1.00 am.")
                .petsAllowed(false)
                .build());
        event14.setOrganizer(org2);
        org2.getOwnEvents().add(event14);
        eventRepository.save(event14);

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
