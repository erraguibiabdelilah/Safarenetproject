package allobaba.group.safarent_project.ws.converter.communConverter;

import allobaba.group.safarent_project.bean.communBean.Location;
import allobaba.group.safarent_project.ws.dto.communDto.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationConverter {
    private ContratConverter contratConverter ;
    private FactureConverter factureConverter ;
    private ReservationConverter  reservationConverter ;

    public LocationConverter(@Lazy ContratConverter contratConverter,@Lazy FactureConverter factureConverter,@Lazy ReservationConverter reservationConverter) {
        this.contratConverter = contratConverter;
        this.factureConverter = factureConverter;
        this.reservationConverter = reservationConverter;
    }

    public LocationDto toDto(Location bean) {
        if(bean == null){return null ;}
        else {
            LocationDto dto = new LocationDto();
            dto.setRef(bean.getRef());
//            if (bean.getFacture() != null) {
//                dto.setFacture(factureConverter.toDto(bean.getFacture()));
//            }
//            if (bean.getContrat() != null) {
//                dto.setContrat(contratConverter.toDto(bean.getContrat()));
//            }
//

        if (bean.getReservation() != null) {
            dto.setReservationDto(reservationConverter.toDto(bean.getReservation()));
        }
            return dto;
        }
    }

    public Location toBean(LocationDto dto) {
        if (dto == null){return  null ;}
        else {
            Location bean = new Location();
            bean.setRef(dto.getRef());
//            if (dto.getFacture() != null) {
//                bean.setFacture(factureConverter.toBean(dto.getFacture()));
//            }
//            if (dto.getContrat() != null) {
//                bean.setContrat(contratConverter.toBean(dto.getContrat()));
//            }

        if (dto.getReservationDto() != null) {
            bean.setReservation(reservationConverter.toBean(dto.getReservationDto()));
        }
            return bean;
        }
    }

    public List<LocationDto> toDto (List<Location> beans){
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Location> toBean(List<LocationDto> dtos){
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }
}
