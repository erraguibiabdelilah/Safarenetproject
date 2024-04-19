package allobaba.group.safarent_project.ws.converter.communConverter;


import allobaba.group.safarent_project.bean.communBean.Facture;
import allobaba.group.safarent_project.ws.dto.communDto.FactureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FactureConverter {
    private LocationConverter locationConverter ;
    private PaiementConverter paiemenetConverter ;

    public FactureConverter(@Lazy LocationConverter locationConverter,@Lazy PaiementConverter paiemenetConverter) {
        this.locationConverter = locationConverter;
        this.paiemenetConverter = paiemenetConverter;
    }

    public FactureDto toDto(Facture bean) {
            if(bean ==null){return null ;}
            else {
                FactureDto dto = new FactureDto();
                dto.setRef(bean.getRef());
                dto.setDateFacture(bean.getDateFacture());
                dto.setMontantTotal(bean.getMontantTotal());
                if (bean.getLocation() != null) {
                    dto.setLocation(locationConverter.toDto(bean.getLocation()));
                }
            if (bean.getPaiement() != null) {
                dto.setPaiementDto(paiemenetConverter.toDto(bean.getPaiement()));
            }


                return dto;
            }
        }

        public Facture toBean(FactureDto dto) {
            if(dto == null){return null ;}
            else {
                Facture bean = new Facture();
                bean.setRef(dto.getRef());
                bean.setDateFacture(dto.getDateFacture());
                bean.setMontantTotal(dto.getMontantTotal());
                if (dto.getLocation() != null) {
                    bean.setLocation(locationConverter.toBean(dto.getLocation()));
                }
            if (dto.getPaiementDto() != null) {
                bean.setPaiement(paiemenetConverter.toBean(dto.getPaiementDto()));
            }
                return bean;
            }
        }
    public List<FactureDto> toDto (List<Facture> beans){
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Facture> toBean(List<FactureDto> dtos){
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }
    }


