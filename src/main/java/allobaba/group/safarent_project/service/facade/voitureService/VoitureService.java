package allobaba.group.safarent_project.service.facade.voitureService;

import allobaba.group.safarent_project.bean.voitureBean.Voiture;

import java.util.List;

public interface VoitureService {
    int save(Voiture voiture);

    List<Voiture> findAll();

    Voiture findByMatricule(String Matricule); // Change 'matricule' to 'Matricule'
    List<Voiture> findByCouleur(String couleur);

    List<Voiture> findByBoitevitesse(String boiteVitesse);

    List<Voiture> findByCategorieVoitureLibelle(String libelle);

    List<Voiture> findByNomModele(String nom);


    List<Voiture> findByVille(String ville);
    int deleteByMatricule(String Matricule); // Change 'matricule' to 'Matricule'

    int update(Voiture voiture);
}
