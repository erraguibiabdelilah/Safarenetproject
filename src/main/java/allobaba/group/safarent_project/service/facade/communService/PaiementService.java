package allobaba.group.safarent_project.service.facade.communService;
;
import allobaba.group.safarent_project.bean.communBean.Paiement;
import allobaba.group.safarent_project.ws.dto.communDto.PaiementDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaiementService {

    int save(Paiement paiement);


    List<Paiement> findAll();

    int update(Paiement paiement);

    Paiement findByRef(String ref);

    int deleteByRef(String ref);


}
