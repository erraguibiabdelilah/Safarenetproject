package allobaba.group.safarent_project.service.facade.appartementService;

import allobaba.group.safarent_project.bean.appartementBean.Appartement;
import allobaba.group.safarent_project.ws.dto.appartementDto.AppartementDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppartementService {
    int save(Appartement appartement);

    List<Appartement> findAll();
    Appartement findByCode(String code);
    int deleteByCode(String code);


    int update(Appartement appartementNv);

    List<Appartement> findByCategoriesAppartementLibelle(String libelle);

    List<Appartement>  findByPropAppartementCin(String cin);

}
