package allobaba.group.safarent_project.service.facade.communService;

import allobaba.group.safarent_project.bean.communBean.Facture;
import allobaba.group.safarent_project.ws.dto.communDto.FactureDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FactureService {
    int save(Facture facture);
    Facture findByRef(String ref);
    List<Facture> findAll();
    int deleteByRef(String ref);

    int update(Facture facture);
}
