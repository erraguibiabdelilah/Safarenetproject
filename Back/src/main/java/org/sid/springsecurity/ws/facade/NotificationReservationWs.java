package org.sid.springsecurity.ws.facade;

import org.sid.springsecurity.bean.NotificationReservation;
import org.sid.springsecurity.service.facade.NotifiactionReservationService;
import org.sid.springsecurity.ws.converter.NotificationReservationConverter;
import org.sid.springsecurity.ws.dto.NotificationReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/safarent/notification/")
public class NotificationReservationWs {

    @Autowired
    private NotifiactionReservationService notifiactionReservationService;
    @Autowired
    private NotificationReservationConverter converter;
    @GetMapping("code/{code}")
    public NotificationReservationDto findByCode(@PathVariable String code) {
        return converter.toDto(notifiactionReservationService.findByCode(code));
    }
    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return notifiactionReservationService.deleteByCode(code);
    }
    @GetMapping
    public List<NotificationReservationDto> findAll() {
        return converter.toDto(notifiactionReservationService.findAll());
    }
    @PostMapping
    public int save(NotificationReservationDto notificationReservationDto) {
        NotificationReservation notificationReservation=converter.toBean(notificationReservationDto);
        return notifiactionReservationService.save(notificationReservation);
    }
}
