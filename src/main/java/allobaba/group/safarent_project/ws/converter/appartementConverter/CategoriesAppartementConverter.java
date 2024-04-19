package allobaba.group.safarent_project.ws.converter.appartementConverter;


import allobaba.group.safarent_project.bean.appartementBean.CategoriesAppartement;
import allobaba.group.safarent_project.ws.dto.appartementDto.CategoriesAppartementDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CategoriesAppartementConverter {

    private AppartementConverter appartementConverter;




    public CategoriesAppartementConverter(AppartementConverter appartementConverter) {
        this.appartementConverter = appartementConverter;
    }

    public CategoriesAppartement toBean(CategoriesAppartementDto dto) {
        if(dto==null){
            return  null;
        }
        else{
            CategoriesAppartement bean = new CategoriesAppartement();
            bean.setLibelle(dto.getLibelle());
            return bean;
        }
    }

    public CategoriesAppartementDto toDto(CategoriesAppartement bean) {
        if(bean==null){
            return  null;
        }
        else {
            CategoriesAppartementDto dto = new CategoriesAppartementDto();
            dto.setLibelle(bean.getLibelle());
            return dto;
        }

    }

    public List<CategoriesAppartement> toBean(List<CategoriesAppartementDto> dtos) {
        List<CategoriesAppartement> beans = new ArrayList<>();
        for (CategoriesAppartementDto dto : dtos) {
            beans.add(toBean(dto));
        }
        return beans;
    }

    public List<CategoriesAppartementDto> toDto(List<CategoriesAppartement> beans) {
        List<CategoriesAppartementDto> dtos = new ArrayList<>();
        for (CategoriesAppartement dto : beans) {
            dtos.add(toDto(dto));
        }
        return dtos;
    }


    public boolean isAppartement() {
        return appartement;
    }

    public void setAppartement(boolean appartement) {
        this.appartement = appartement;
    }

    private boolean appartement;
    CategoriesAppartementConverter(){
        initObject(true);
    }
    public void initObject(boolean value) {
        this.appartement = value;
    }

}
