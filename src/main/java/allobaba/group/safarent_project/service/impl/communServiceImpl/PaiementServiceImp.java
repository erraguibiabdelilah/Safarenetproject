package allobaba.group.safarent_project.service.impl.communServiceImpl;

import allobaba.group.safarent_project.bean.appartementBean.Appartement;
import allobaba.group.safarent_project.bean.appartementBean.PropAppartement;
import allobaba.group.safarent_project.bean.communBean.Client;
import allobaba.group.safarent_project.bean.communBean.Facture;
import allobaba.group.safarent_project.bean.communBean.Paiement;
import allobaba.group.safarent_project.bean.communBean.Reservation;
import allobaba.group.safarent_project.bean.voitureBean.AgenceLocation;

import allobaba.group.safarent_project.bean.voitureBean.Voiture;
import allobaba.group.safarent_project.dao.communDao.PaiementDao;
import allobaba.group.safarent_project.service.facade.appartementService.PropAppartementService;
import allobaba.group.safarent_project.service.facade.communService.FactureService;
import allobaba.group.safarent_project.service.facade.communService.PaiementService;
import allobaba.group.safarent_project.service.facade.voitureService.AgenceLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Lazy
@Service
public class PaiementServiceImp implements PaiementService {
    @Autowired
    private PaiementDao paiementDao;
    @Autowired
    private PropAppartementService propAppartementService;
    @Autowired
    private AgenceLocationService agenceLocationService;
    @Autowired
    private FactureService factureService ;



    public int save(Paiement paiement) {

        if (paiement.getRef() == null) return -1;

        if (paiement.getFacture() == null || paiement.getFacture().getRef() == null) return -2;

        Facture facture = factureService.findByRef(paiement.getFacture().getRef());
        if (facture == null) return -3;
        paiement.setFacture(facture);

        if (paiement.getAgenceLocation() != null && paiement.getAgenceLocation().getIceAgLoc() != null) {
            AgenceLocation agenceLocation = agenceLocationService.findByiceAgLoc(paiement.getAgenceLocation().getIceAgLoc());
            if (agenceLocation == null) return -4;
            paiement.setAgenceLocation(agenceLocation);
        } else {
            paiement.setAgenceLocation(null);
        }

        if (paiement.getProp_appartement() != null && paiement.getProp_appartement().getCin() != null) {
            PropAppartement propAppartement = propAppartementService.findByCin(paiement.getProp_appartement().getCin());
            if (propAppartement == null) {
                return -5;
            }
            paiement.setProp_appartement(propAppartement);
        } else {
        }paiement.setProp_appartement(null);

        paiementDao.save(paiement);

        return 1;


    }

    @Override
    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }

    @Override
    public int update(Paiement paiement) {

        Paiement existingPaiement = findByRef(paiement.getRef());

        if (existingPaiement == null) {
            return -1;
        }

        try {
            if (paiement.getProp_appartement() == null || paiement.getAgenceLocation() == null) {
                return -2;
            }
            if (paiement.getProp_appartement().getCin() == null || paiement.getAgenceLocation().getIceAgLoc() == null || paiement.getFacture().getRef() == null) {
                return -3;
            }
            PropAppartement propAppartement = propAppartementService.findByCin(paiement.getProp_appartement().getCin());
            AgenceLocation agenceLocation = agenceLocationService.findByiceAgLoc(paiement.getAgenceLocation().getIceAgLoc());
            Facture facture=factureService.findByRef(paiement.getFacture().getRef());

            existingPaiement.setRibClient(paiement.getRibClient());
            existingPaiement.setDatePaiement(paiement.getDatePaiement());
            existingPaiement.setFacture(facture);
            existingPaiement.setAgenceLocation(agenceLocation);
            existingPaiement.setProp_appartement(propAppartement);



            paiementDao.save(existingPaiement);

            return 1;

        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de paiement : " + e.getMessage());
            e.printStackTrace();
            return -4;
        }
    }
    @Override
    public Paiement findByRef(String ref) {
        return paiementDao.findByRef(ref);
    }

    @Transactional
    @Override
    public int deleteByRef(String ref) {
        return paiementDao.deleteByRef(ref);
    }

}
