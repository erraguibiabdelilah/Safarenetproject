package allobaba.group.safarent_project.service.facade;

import allobaba.group.safarent_project.bean.NotificationReservation;

import java.util.List;

public interface NotifiactionReservationService {
    public NotificationReservation findByCode(String code);
    public int deleteByCode(String code);

    List<NotificationReservation> findAll();

    int save(NotificationReservation notificationReservation);
}
