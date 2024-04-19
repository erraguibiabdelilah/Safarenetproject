package allobaba.group.safarent_project.service.facade.communService;

import allobaba.group.safarent_project.bean.communBean.Reservation;
import allobaba.group.safarent_project.ws.dto.communDto.ReservationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {
    Reservation findByRef(String ref);

    List<Reservation> findAll();

    int save(Reservation reservation);
    int deleteByRef(String ref);

    Reservation findByVoitureMatricule(String matricule);
    Reservation findByAppartementCode(String code);


    List<Reservation> findAllByClientCin(String cin);

    Reservation findByLocationsRef(String ref);

}
