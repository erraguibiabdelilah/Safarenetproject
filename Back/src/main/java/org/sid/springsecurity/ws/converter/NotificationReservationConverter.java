package org.sid.springsecurity.ws.converter;


import org.sid.springsecurity.bean.NotificationReservation;
import org.sid.springsecurity.ws.dto.NotificationReservationDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class NotificationReservationConverter {
    public NotificationReservation toBean(NotificationReservationDto dto) {
        if(dto==null){
            return  null;
        }
        else {
            NotificationReservation bean = new NotificationReservation();
            bean.setId(dto.getId());
            bean.setCode(dto.getCode());
            bean.setCinClient(dto.getCinClient());
            bean.setNomClient(dto.getNomClient());
            bean.setIce_Agence(dto.getIce_Agence());
            bean.setDateReservation(dto.getDateReservation());
            bean.setCodeAppartement(dto.getCodeAppartement());
            bean.setMatriculeVoiture(dto.getMatriculeVoiture());
            bean.setCinPropAppartement(dto.getCinPropAppartement());
            bean.setVisible(dto.isIsvisible());
            return bean;
        }
    }
    public NotificationReservationDto toDto(NotificationReservation bean) {
        if(bean==null){
            return  null;
        }
        else {
            NotificationReservationDto dto = new NotificationReservationDto();
            dto.setId(bean.getId());
            dto.setCode(bean.getCode());
            dto.setCinClient(bean.getCinClient());
            dto.setNomClient(bean.getNomClient());
            dto.setIce_Agence(bean.getIce_Agence());
            dto.setDateReservation(bean.getDateReservation());
            dto.setCodeAppartement(bean.getCodeAppartement());
            dto.setMatriculeVoiture(bean.getMatriculeVoiture());
            dto.setCinPropAppartement(bean.getCinPropAppartement());
            dto.setIsvisible(bean.isVisible());
            return dto;
        }
    }
    public List<NotificationReservation> toBean(List<NotificationReservationDto> dtos) {
        List<NotificationReservation> beans = new ArrayList<>();
        for (NotificationReservationDto dto : dtos) {
            beans.add(toBean(dto));
        }
        return beans;
    }
    public List<NotificationReservationDto> toDto(List<NotificationReservation> beans) {
        List<NotificationReservationDto> dtos = new ArrayList<>();
        for (NotificationReservation dto : beans) {
            dtos.add(toDto(dto));
        }
        return dtos;
    }
}
