package allobaba.group.safarent_project.service.impl.communServiceImpl;


import allobaba.group.safarent_project.bean.appartementBean.Appartement;
import allobaba.group.safarent_project.bean.communBean.Client;
import allobaba.group.safarent_project.bean.communBean.Reservation;
import allobaba.group.safarent_project.bean.voitureBean.AgenceLocation;
import allobaba.group.safarent_project.bean.voitureBean.CategorieVoiture;
import allobaba.group.safarent_project.bean.voitureBean.Voiture;
import allobaba.group.safarent_project.dao.communDao.ReservationDao;
import allobaba.group.safarent_project.service.facade.appartementService.AppartementService;
import allobaba.group.safarent_project.service.facade.communService.ClientService;
import allobaba.group.safarent_project.service.facade.communService.ReservationService;
import allobaba.group.safarent_project.service.facade.voitureService.VoitureService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Lazy
@Service
public class ReservationServiceImpl implements ReservationService {

    @Override
    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    @Override
    public Reservation findByRef(String ref) {
        return reservationDao.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return reservationDao.deleteByRef(ref);
    }

    @Override
    public Reservation findByVoitureMatricule(String matricule) {
        return reservationDao.findByVoitureMatricule(matricule);
    }

    @Override
    public Reservation findByAppartementCode(String code) {
        return reservationDao.findByAppartementCode(code);
    }

    @Override
    public List<Reservation> findAllByClientCin(String cin) {
        return reservationDao.findAllByClientCin(cin);
    }

    @Override
    public Reservation findByLocationsRef(String ref) {
        return reservationDao.findByLocationsRef(ref);
    }

    @Override
    public int save(Reservation reservation) {

        if (reservation.getRef() == null) return -1;

        if (reservation.getClient() == null || reservation.getClient().getCin() == null) return -3;

        Client client = clientService.findByCin(reservation.getClient().getCin());
        if (client == null) return -4;
        reservation.setClient(client);

        if (reservation.getVoiture() != null && reservation.getVoiture().getMatricule() != null) {
            Voiture voiture = voitureService.findByMatricule(reservation.getVoiture().getMatricule());
            if (voiture == null) return -5;
            reservation.setVoiture(voiture);
        } else {
            reservation.setVoiture(null);
        }

        if (reservation.getAppartement() != null && reservation.getAppartement().getCode() != null) {
            Appartement appartement = appartementService.findByCode(reservation.getAppartement().getCode());
            if (appartement == null) {
                return -6;
            }
            reservation.setAppartement(appartement);
        } else {
            reservation.setAppartement(null);
        }

        reservationDao.save(reservation);

        return 1;


    }


    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private ClientService clientService;

    @Autowired
    private VoitureService voitureService;

    @Autowired
    private AppartementService appartementService;

}
