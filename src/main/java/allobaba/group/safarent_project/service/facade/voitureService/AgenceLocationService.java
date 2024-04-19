package allobaba.group.safarent_project.service.facade.voitureService;

import allobaba.group.safarent_project.bean.voitureBean.AgenceLocation;
import allobaba.group.safarent_project.ws.dto.voitureDto.AgenceLocationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AgenceLocationService {


    int save(AgenceLocation agenceLocation);

    AgenceLocation findByiceAgLoc(Long iceAgLoc);

    List<AgenceLocation> findAll();



    int update(AgenceLocation agenceLocation);

    int deleteByiceAgLoc(Long iceAgLoc);
}
