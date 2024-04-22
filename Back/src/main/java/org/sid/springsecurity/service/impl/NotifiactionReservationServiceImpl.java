package org.sid.springsecurity.service.impl;

import org.sid.springsecurity.bean.NotificationReservation;
import org.sid.springsecurity.dao.NotificationReservationDao;
import org.sid.springsecurity.service.facade.NotifiactionReservationService;
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
