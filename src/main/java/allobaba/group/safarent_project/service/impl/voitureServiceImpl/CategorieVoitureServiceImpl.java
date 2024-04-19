package allobaba.group.safarent_project.service.impl.voitureServiceImpl;

import allobaba.group.safarent_project.bean.communBean.Reservation;
import allobaba.group.safarent_project.bean.voitureBean.AgenceLocation;
import allobaba.group.safarent_project.bean.voitureBean.CategorieVoiture;
import allobaba.group.safarent_project.bean.voitureBean.Voiture;
import allobaba.group.safarent_project.dao.voitureDao.CategorieVoitureDao;
import allobaba.group.safarent_project.service.facade.voitureService.CategorieVoitureService;
import allobaba.group.safarent_project.ws.converter.voitureConverter.CategorieVoitureConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategorieVoitureServiceImpl implements CategorieVoitureService {


    @Autowired
    private CategorieVoitureDao categorieVoitureDao;
    @Autowired
    private CategorieVoitureConverter categorieVoitureConverter;

    @Override
    public int save(CategorieVoiture categorieVoiture) {
        try {
            if(categorieVoitureDao.findByLibelle(categorieVoiture.getLibelle())!=null){return -1;}
            if(categorieVoiture.getLibelle()==null){return -2;}

            categorieVoitureDao.save(categorieVoiture);
            return 1;

        } catch (Exception e) {
            System.err.println("Erreur lors de la sauvegarde de la categorie: " + e.getMessage());
            e.printStackTrace();
            return -4;
        }
    }


    @Override
    public CategorieVoiture findByLibelle(String libelle) {
        return categorieVoitureDao.findByLibelle(libelle);
    }
    @Override
    public List<CategorieVoiture> findAll() {
        return categorieVoitureDao.findAll();
    }

    @Transactional
    @Override
    public int  deleteByLibelle(String libelle) {
        return  categorieVoitureDao.deleteByLibelle(libelle);
    }
}
