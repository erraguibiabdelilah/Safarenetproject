package allobaba.group.safarent_project.dao.voitureDao;

import allobaba.group.safarent_project.bean.voitureBean.CategorieVoiture;
import allobaba.group.safarent_project.bean.voitureBean.Voiture;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieVoitureDao extends JpaRepository<CategorieVoiture, Long> {
    CategorieVoiture findByLibelle(String libelle);
    int deleteByLibelle(String libelle);

}
