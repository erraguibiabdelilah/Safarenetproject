package org.sid.springsecurity.service.facade.voitureService;


import org.sid.springsecurity.bean.voitureBean.CategorieVoiture;

import java.util.List;
public interface CategorieVoitureService {

    int save(CategorieVoiture categorieVoiture);

    CategorieVoiture findByLibelle(String libelle);


    List<CategorieVoiture> findAll();

    int deleteByLibelle(String libelle);
}
