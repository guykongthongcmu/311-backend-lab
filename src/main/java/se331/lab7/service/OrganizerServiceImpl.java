package se331.lab7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab7.dao.OrganizerDao;
import se331.lab7.entity.Organizer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{
    final OrganizerDao organizerDao;

    @Override
    public Integer getOrganizerSize() {
        return organizerDao.getOrganizerSize();
    }

    @Override
    public List<Organizer> getOrganizer(Integer pageSize, Integer page) {
        return organizerDao.getOrganizer(pageSize, page);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerDao.getOrganizer(id);
    }
}
