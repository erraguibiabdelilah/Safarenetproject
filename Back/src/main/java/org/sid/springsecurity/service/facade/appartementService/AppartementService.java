package org.sid.springsecurity.service.facade.appartementService;


import org.sid.springsecurity.bean.appartementBean.Appartement;

import java.util.List;

public interface AppartementService {
    int save(Appartement appartement);

    List<Appartement> findAll();
    Appartement findByCode(String code);
    int deleteByCode(String code);


    int update(Appartement appartementNv);

    List<Appartement> findByCategoriesAppartementLibelle(String libelle);

    List<Appartement>  findByPropAppartementCin(String cin);

}
