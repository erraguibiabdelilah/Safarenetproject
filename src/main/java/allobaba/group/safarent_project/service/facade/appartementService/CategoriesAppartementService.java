package allobaba.group.safarent_project.service.facade.appartementService;

import allobaba.group.safarent_project.bean.appartementBean.CategoriesAppartement;
import allobaba.group.safarent_project.ws.dto.appartementDto.CategoriesAppartementDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface CategoriesAppartementService {
    int save(CategoriesAppartementDto categoriesAppartement);
    List<CategoriesAppartement> findAll();

    int update(String libelle, String libelleNew);

    CategoriesAppartement findByLibelle(String libelle);
    int deleteByLibelle(String libelle);
}
