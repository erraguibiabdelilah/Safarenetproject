package org.sid.springsecurity.dao;

import org.sid.springsecurity.bean.NotificationReservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationReservationDao extends JpaRepository<NotificationReservation,Long> {

     NotificationReservation findByCode(String code);
     int deleteByCode(String code);
}
