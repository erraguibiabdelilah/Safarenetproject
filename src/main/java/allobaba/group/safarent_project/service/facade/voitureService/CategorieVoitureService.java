package allobaba.group.safarent_project.service.facade.voitureService;
import allobaba.group.safarent_project.bean.voitureBean.CategorieVoiture;
import allobaba.group.safarent_project.ws.dto.voitureDto.CategorieVoitureDto;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface CategorieVoitureService {

    int save(CategorieVoiture categorieVoiture);

    CategorieVoiture findByLibelle(String libelle);


    List<CategorieVoiture> findAll();

    int deleteByLibelle(String libelle);
}
