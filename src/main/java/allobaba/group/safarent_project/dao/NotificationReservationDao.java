package allobaba.group.safarent_project.dao;

import allobaba.group.safarent_project.bean.NotificationReservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationReservationDao extends JpaRepository<NotificationReservation,Long> {

    public NotificationReservation findByCode(String code);
    public int deleteByCode(String code);
}
