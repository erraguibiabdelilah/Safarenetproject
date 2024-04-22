package org.sid.springsecurity.ws.converter.appartementConverter;

import org.sid.springsecurity.bean.appartementBean.Appartement;
import org.sid.springsecurity.ws.converter.communConverter.ReservationConverter;
import org.sid.springsecurity.ws.dto.appartementDto.AppartementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AppartementConverter {

    @Autowired
    private ReservationConverter reservationConverter;
    @Autowired
    private  CategoriesAppartementConverter categoriesAppartementConverter;
    @Autowired
    private  PropAppartemenetConverter propAppartemenetConverter;



    public AppartementConverter(ReservationConverter reservationConverter, CategoriesAppartementConverter categoriesAppartementConverter, PropAppartemenetConverter propAppartemenetConverter) {
        this.reservationConverter = reservationConverter;
        this.categoriesAppartementConverter = categoriesAppartementConverter;
        this.propAppartemenetConverter = propAppartemenetConverter;
    }


    public Appartement toBean(AppartementDto dto) {
        if(dto==null){
            return  null;
        }
        else {
            Appartement bean = new Appartement();
            bean.setCode(dto.getCode());
            bean.setSuperficie(dto.getSuperficie());
            bean.setAdresse(dto.getAdresse());
            bean.setLoyerMensuel(dto.getLoyerMensuel());

            if( dto.getCategoriesAppartementDto()!=null){
                bean.setCategoriesAppartement(categoriesAppartementConverter.toBean(dto.getCategoriesAppartementDto()));
            }
            if( dto.getPropAppartemenetDto()!=null){
                bean.setPropAppartement(propAppartemenetConverter.toBean(dto.getPropAppartemenetDto()));
            }
            if (dto.getReservationDtos()!=null){
                bean.setReservation(reservationConverter.toBean(dto.getReservationDtos()));
            }
            return bean;
        }

    }
    public AppartementDto toDto(Appartement bean) {
        if(bean==null){
            return  null;
        }
        else {
            AppartementDto dto = new AppartementDto();
            dto.setCode(bean.getCode());
            dto.setSuperficie(bean.getSuperficie());
            dto.setAdresse(bean.getAdresse());
            dto.setLoyerMensuel(bean.getLoyerMensuel());

            if( bean.getCategoriesAppartement()!=null){
                dto.setCategoriesAppartementDto(categoriesAppartementConverter.toDto(bean.getCategoriesAppartement()));
            }
            if( bean.getPropAppartement()!=null){
                dto.setPropAppartemenetDto(propAppartemenetConverter.toDto(bean.getPropAppartement()));
            }
            if (bean.getReservation()!=null){
                dto.setReservationDtos(reservationConverter.toDto(bean.getReservation()));
            }
            return dto;
        }

    }

    public List<Appartement> toBean(List<AppartementDto> dtos) {
        List<Appartement> beans = new ArrayList<>();
        for (AppartementDto dto : dtos) {
            beans.add(toBean(dto));
        }
        return beans;
    }

    public List<AppartementDto> toDto(List<Appartement> beans) {
        List<AppartementDto> dtos = new ArrayList<>();
        for (Appartement dto : beans) {
            dtos.add(toDto(dto));
        }
        return dtos;
    }

    AppartementConverter(){
        initObject(true);
    }

    private boolean reservation;

    private boolean categoriesAppartement;

    private boolean propAppartemenet;

    public void initObject(boolean value) {
        this.reservation = value;
        this.categoriesAppartement = value;
        this.propAppartemenet = value;
    }

}
