package allobaba.group.safarent_project.dao.voitureDao;

import allobaba.group.safarent_project.bean.communBean.Client;
import allobaba.group.safarent_project.bean.communBean.Paiement;
import allobaba.group.safarent_project.bean.voitureBean.AgenceLocation;
import allobaba.group.safarent_project.bean.voitureBean.Voiture;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AgenceLocationDao extends JpaRepository<AgenceLocation,Long> {
    AgenceLocation findByIceAgLoc(Long id);
    int deleteByIceAgLoc(Long ice);
}
