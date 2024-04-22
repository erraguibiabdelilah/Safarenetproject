package org.sid.springsecurity.service.impl.communServiceImpl;

import org.sid.springsecurity.bean.communBean.Contrat;
import org.sid.springsecurity.bean.communBean.Facture;
import org.sid.springsecurity.bean.communBean.Location;
import org.sid.springsecurity.bean.communBean.Reservation;
import org.sid.springsecurity.dao.communDao.LocationDao;
import org.sid.springsecurity.service.facade.communService.ContratService;
import org.sid.springsecurity.service.facade.communService.FactureService;
import org.sid.springsecurity.service.facade.communService.LocationService;
import org.sid.springsecurity.service.facade.communService.ReservationService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    private LocationDao locationDao ;
    private FactureService factureService ;
    private ContratService contratService ;
    private ReservationService reservationService;


    public LocationServiceImpl( LocationDao locationDao,@Lazy FactureService factureService,@Lazy ContratService contratService,@Lazy ReservationService reservationService) {
        this.locationDao = locationDao;
        this.factureService = factureService;
        this.contratService = contratService;
        this.reservationService = reservationService;
    }

    @Override
    public int save(Location location) {
        if (location == null) {
            System.out.println("location null");
            return -1;
        }
        if (findByRef(location.getRef()) != null) {
            System.out.println("location (ref) deja existed");
            return -2;
        }
        String ref = location.getReservation().getRef();
        Reservation reservation = reservationService.findByRef(ref);
        if(location.getReservation()==null){
            return -3;
        }
        if (reservation == null) {
            System.out.println("reservation est null");
            return -4;
        }
        if (reservationService.findByRef(reservation.getRef())  == null) {
            System.out.println("Cette reservation (ref) n'existe pas");
            return -5;
        }
        location.setReservation(reservation);
        locationDao.save(location);
        return 1;
    }

    @Override
    public List<Location> findAll() {
        return locationDao.findAll();
    }

    @Override
    public Location findByRef(String ref) {
        return locationDao.findByRef(ref);
    }

    @Transactional
    @Override
    public int deleteByRef(String ref) {
        return locationDao.deleteByRef(ref);
    }
    @Override
    public int update(Location location) {
        Location existingLocation = findByRef(location.getRef());

        if (existingLocation == null) {
            return -1;
        }

        try {
            if (location.getReservation() == null) {
                return -2;
            }
            if (location.getReservation().getRef() == null) {
                return -3;
            }
            Reservation reservation = reservationService.findByRef(location.getReservation().getRef());
            if (location.getFacture() != null) {
                Facture facture = factureService.findByRef(location.getFacture().getRef());
                location.setFacture(facture);
            } else {
                location.setFacture(null);
            }
            if (location.getContrat() != null) {
                Contrat contrat = contratService.findByNumContrat(location.getContrat().getNumContrat());
                location.setContrat(contrat);
            } else {
                location.setFacture(null);
            }

            existingLocation.setReservation(reservation);
            locationDao.save(existingLocation);
            return 1;
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de la location : " + e.getMessage());
            e.printStackTrace();
            return -4;
        }
    }
}


