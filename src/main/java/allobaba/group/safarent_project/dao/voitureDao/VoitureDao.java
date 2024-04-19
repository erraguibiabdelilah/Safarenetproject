package allobaba.group.safarent_project.dao.voitureDao;

import allobaba.group.safarent_project.bean.voitureBean.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoitureDao extends JpaRepository<Voiture, Long> {
    Voiture findByMatricule(String Matricule);
    List<Voiture> findByCouleur(String couleur);

    List<Voiture> findByBoitevitesse(String boiteVitesse);
    List<Voiture> findByCategorieVoitureLibelle(String libelle);

    List<Voiture> findByNomModele(String nom);

    List<Voiture> findByVille(String ville);
    int deleteByMatricule(String Matricule);
}
