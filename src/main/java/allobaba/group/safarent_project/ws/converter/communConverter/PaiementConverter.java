package allobaba.group.safarent_project.ws.converter.communConverter;

import allobaba.group.safarent_project.bean.communBean.Paiement;
import allobaba.group.safarent_project.ws.converter.appartementConverter.PropAppartemenetConverter;
import allobaba.group.safarent_project.ws.converter.voitureConverter.AgenceLocationConverter;
import allobaba.group.safarent_project.ws.dto.communDto.PaiementDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaiementConverter {
   public PaiementConverter(@Lazy AgenceLocationConverter agenceLocationConverter,@Lazy PropAppartemenetConverter propAppartemenetConverter,@Lazy FactureConverter factureConverter) {
      this.agenceLocationConverter = agenceLocationConverter;
      this.propAppartemenetConverter = propAppartemenetConverter;
      this.factureConverter = factureConverter;
   }

   private AgenceLocationConverter agenceLocationConverter;
    private PropAppartemenetConverter propAppartemenetConverter ;
    private FactureConverter factureConverter ;
   public Paiement toBean(PaiementDto dto){
      if(dto == null){return null ;}
      else {
         Paiement bean = new Paiement();
         bean.setRef(dto.getRef());
         bean.setDatePaiement(dto.getDatePaiement());
         bean.setRibClient(dto.getRibClient());


         if (dto.getPropAppartemenetDto() != null) {
            bean.setProp_appartement(propAppartemenetConverter.toBean(dto.getPropAppartemenetDto()));
         }

         if (dto.getAgenceLocationDto() != null) {
            bean.setAgenceLocation(agenceLocationConverter.toBean(dto.getAgenceLocationDto()));
         }

         if (dto.getFactureDto() != null) {
            bean.setFacture(factureConverter.toBean(dto.getFactureDto()));
         }
         return bean;
      }
   }

   public PaiementDto toDto(Paiement bean) {
      if (bean == null) {
         return null;
      } else {
         PaiementDto dto = new PaiementDto();
         dto.setRef(bean.getRef());
         dto.setDatePaiement(bean.getDatePaiement());
         dto.setRibClient(bean.getRibClient());

         if (bean.getAgenceLocation() != null) {
            dto.setAgenceLocationDto(agenceLocationConverter.toDto(bean.getAgenceLocation()));
         }
         if (bean.getFacture() != null) {
            dto.setFactureDto(factureConverter.toDto(bean.getFacture()));
         }
         if (bean.getProp_appartement() != null) {
            dto.setPropAppartemenetDto(propAppartemenetConverter.toDto(bean.getProp_appartement()));
         }
         return dto;
      }
   }
   public List<PaiementDto> toDto(List<Paiement> beans){
      return beans.stream().map(this::toDto).collect(Collectors.toList());
   }

   public List<Paiement> toBean(List<PaiementDto> dtos){
      return dtos.stream().map(this::toBean).collect(Collectors.toList());
   }
}

