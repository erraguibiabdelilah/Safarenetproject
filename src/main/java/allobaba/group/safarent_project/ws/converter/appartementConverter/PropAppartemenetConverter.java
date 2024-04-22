package allobaba.group.safarent_project.ws.converter.appartementConverter;
import allobaba.group.safarent_project.bean.appartementBean.PropAppartement;
import allobaba.group.safarent_project.ws.converter.communConverter.ClientConverter;
import allobaba.group.safarent_project.ws.converter.communConverter.PaiementConverter;
import allobaba.group.safarent_project.ws.dto.appartementDto.PropAppartemenetDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropAppartemenetConverter {
    private ClientConverter clientConverter;

    private PaiementConverter paiementConverter;

    private AppartementConverter appartementConverter;


    public PropAppartemenetConverter(ClientConverter clientConverter, PaiementConverter paiementConverter, AppartementConverter appartementConverter) {
        this.clientConverter = clientConverter;
        this.paiementConverter = paiementConverter;
        this.appartementConverter = appartementConverter;
    }

    public PropAppartement toBean(PropAppartemenetDto dto) {
        if(dto==null){
            return  null;
        }
        else {
            PropAppartement bean = new PropAppartement();
            bean.setNom(dto.getNom());
            bean.setPrenom(dto.getPrenom());
            bean.setNumTele(dto.getNumTele());
            bean.setEmail(dto.getEmail());
            bean.setRibPropAppt(dto.getRibPropAppt());
            bean.setNumCompteBkPropApp(dto.getNumCompteBkPropApp());
            bean.setCin(dto.getCin());
            bean.setUsernamePropAppt(dto.getUsernamePropAppt());
            bean.setPassword(dto.getPassword());

            return bean;
        }
    }

    public PropAppartemenetDto toDto(PropAppartement bean) {
        if(bean==null){
            return null;
        }
        else {
            PropAppartemenetDto dto = new PropAppartemenetDto();
            dto.setNom(bean.getNom());
            dto.setPrenom(bean.getPrenom());
            dto.setNumTele(bean.getNumTele());
            dto.setEmail(bean.getEmail());
            dto.setRibPropAppt(bean.getRibPropAppt());
            dto.setNumCompteBkPropApp(bean.getNumCompteBkPropApp());
            dto.setCin(bean.getCin());
            dto.setUsernamePropAppt(bean.getUsernamePropAppt());
            dto.setPassword(bean.getPassword());

            return dto;
        }

    }

    public List<PropAppartement> toBean(List<PropAppartemenetDto> dtos) {
        List<PropAppartement> beans = new ArrayList<>();
        for (PropAppartemenetDto dto : dtos) {
            beans.add(toBean(dto));
        }
        return beans;
    }
    public List<PropAppartemenetDto> toDto(List<PropAppartement> beans) {
        List<PropAppartemenetDto> dtos = new ArrayList<>();
        for (PropAppartement dto : beans) {
            dtos.add(toDto(dto));
        }
        return dtos;
    }

    private boolean client;
    private boolean paiement;
    private boolean appartement;

    PropAppartemenetConverter(){
        initObject(true);
    }
    public void initObject(boolean value) {
        this.client = value;
        this.paiement = value;
        this.appartement = value;
    }


}
