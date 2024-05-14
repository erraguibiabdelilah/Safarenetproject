package org.sid.springsecurity.dao.notificationDao;

import org.sid.springsecurity.bean.notification.NotificationReservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationReservationDao extends JpaRepository<NotificationReservation,Long> {

     NotificationReservation findByCode(String code);
     int deleteByCode(String code);
}
