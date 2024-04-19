package allobaba.group.safarent_project.service.impl;

import allobaba.group.safarent_project.bean.NotificationReservation;
import allobaba.group.safarent_project.dao.NotificationReservationDao;
import allobaba.group.safarent_project.service.facade.NotifiactionReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotifiactionReservationServiceImpl implements NotifiactionReservationService {
   @Autowired
    private NotificationReservationDao notificationReservationDao;

    @Override
    public NotificationReservation findByCode(String code) {
        return notificationReservationDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return notificationReservationDao.deleteByCode(code);
    }
    @Override
    public List<NotificationReservation> findAll() {
        return notificationReservationDao.findAll();
    }

    @Override
    public int save(NotificationReservation notificationReservation){
        if(notificationReservation.getCode()==null){
            return -1;
        }
        notificationReservationDao.save(notificationReservation);
        return 1;
    }
}
