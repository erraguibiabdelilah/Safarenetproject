package allobaba.group.safarent_project.service.facade.appartementService;

import allobaba.group.safarent_project.bean.appartementBean.PropAppartement;
import allobaba.group.safarent_project.ws.dto.appartementDto.PropAppartemenetDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PropAppartementService {
    int save(PropAppartement propAppartement);
    List<PropAppartement> findAll();
    int update(PropAppartemenetDto propAppartemenetDto);
    PropAppartement findByCin(String cin);
    int deleteByCin(String cin);


}
