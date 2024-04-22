package org.sid.springsecurity.service.impl.appartementServiceImpl;


import org.sid.springsecurity.bean.appartementBean.Appartement;
import org.sid.springsecurity.bean.appartementBean.CategoriesAppartement;
import org.sid.springsecurity.bean.appartementBean.PropAppartement;
import org.sid.springsecurity.dao.appartementDao.AppartementDao;
import org.sid.springsecurity.service.facade.appartementService.AppartementService;
import org.sid.springsecurity.service.facade.appartementService.CategoriesAppartementService;
import org.sid.springsecurity.service.facade.appartementService.PropAppartementService;
import org.sid.springsecurity.service.facade.communService.ReservationService;
import org.sid.springsecurity.ws.converter.appartementConverter.AppartementConverter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Lazy

@Service
public class AppartementServiceImpl implements AppartementService {
    private final AppartementDao appartementDao;
    private final AppartementConverter appartementConverter;


    private final CategoriesAppartementService categoriesAppartementService;
    private final PropAppartementService propAppartementService;

    private final ReservationService reservationService;

    public AppartementServiceImpl(AppartementDao appartementDao, AppartementConverter appartementConverter, CategoriesAppartementService categoriesAppartementService, PropAppartementService propAppartementService, ReservationService reservationService) {
        this.appartementDao = appartementDao;
        this.appartementConverter = appartementConverter;
        this.categoriesAppartementService = categoriesAppartementService;
        this.propAppartementService = propAppartementService;
        this.reservationService = reservationService;
    }

    @Override
    public int save(Appartement appartement) {
        if (appartement.getCode() == null ) {
            return -1;
        }
        else if (appartementDao.findByCode(appartement.getCode()) != null) {
            return -2;
        }
        else {
            String libelle=appartement.getCategoriesAppartement().getLibelle();
            String cin=appartement.getPropAppartement().getCin();

            System.out.println(appartement.getReservation());
            CategoriesAppartement categoriesAppartement = categoriesAppartementService.findByLibelle(libelle);
            PropAppartement propAppartement = propAppartementService.findByCin(cin);

            if (categoriesAppartement == null || propAppartement == null) {
                return -3;
            }
            if (categoriesAppartementService.findByLibelle(categoriesAppartement.getLibelle()) != null ||
                    propAppartementService.findByCin(propAppartement.getCin()) != null ) {
                appartement.setCategoriesAppartement(categoriesAppartement);
                appartement.setPropAppartement(propAppartement);
            }

            appartementDao.save(appartement);
            return 1;
        }
    }
    @Override
    public List<Appartement> findAll() {
        return appartementDao.findAll();
    }

    @Override
    public Appartement findByCode(String code) {
        return appartementDao.findByCode(code);
    }
    @Transactional
    @Override
    public int deleteByCode(String code) {
        return appartementDao.deleteByCode(code);
    }

    @Override
    public int update(Appartement appartementNv) {
        if (appartementNv == null) {
            return -1;
        }

        String code = appartementNv.getCode();

        if (code == null) {
            return -2;
        }

        Appartement appartement = appartementDao.findByCode(code);
        if (appartement == null) {
            return -3;
        }

        String libelle=appartementNv.getCategoriesAppartement().getLibelle();
        String cin=appartementNv.getPropAppartement().getCin();

        if(libelle==null  || cin==null || cin.isEmpty() || libelle.isEmpty()){

            return -5;
        }

        CategoriesAppartement categoriesAppartement=categoriesAppartementService.findByLibelle(libelle);
        PropAppartement propAppartement=propAppartementService.findByCin(cin);

        appartement.setCode(appartementNv.getCode());
        appartement.setSuperficie(appartementNv.getSuperficie());
        appartement.setAdresse(appartementNv.getAdresse());
        appartement.setLoyerMensuel(appartementNv.getLoyerMensuel());

        if(categoriesAppartement!=null){
            appartement.setCategoriesAppartement(categoriesAppartement);
        }
        if(propAppartement!=null){
            appartement.setPropAppartement(propAppartement);
        }
        appartementDao.save(appartement);
        return 1;
    }

    @Override
    public List<Appartement> findByCategoriesAppartementLibelle(String libelle) {
        return appartementDao.findByCategoriesAppartementLibelle(libelle);
    }

    @Override
    public List<Appartement> findByPropAppartementCin(String cin) {
        return appartementDao.findByPropAppartementCin(cin);
    }
}
