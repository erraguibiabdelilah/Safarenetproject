package allobaba.group.safarent_project.service.facade.communService;

import allobaba.group.safarent_project.bean.communBean.Facture;
import allobaba.group.safarent_project.bean.communBean.Location;
import allobaba.group.safarent_project.ws.dto.communDto.FactureDto;
import allobaba.group.safarent_project.ws.dto.communDto.LocationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocationService {
    int save(Location location);
    List<Location> findAll();

    Location findByRef(String ref);

    int deleteByRef(String ref);

    int update(Location voiture);
}
