package org.sid.springsecurity.service.facade.appartementService;


import org.sid.springsecurity.bean.appartementBean.Appartement;
import org.sid.springsecurity.bean.photo.ImageModule;

import java.util.List;

public interface AppartementService {
    List<ImageModule> getImagesByProductRef(String code);

    int save(Appartement appartement);

    List<Appartement> findAll();
    Appartement findByCode(String code);
    int deleteByCode(String code);


    int update(Appartement appartementNv);

    List<Appartement> findByCategoriesAppartementLibelle(String libelle);

    List<Appartement>  findByPropAppartementCin(String cin);

    List<Appartement> findByAdresse(String adresse);

    List<Appartement> findByLoyerMensuelLessThanEqual(double mont);
}
