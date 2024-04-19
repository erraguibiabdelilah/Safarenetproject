package allobaba.group.safarent_project.service.impl.appartementServiceImpl;

import allobaba.group.safarent_project.bean.appartementBean.CategoriesAppartement;
import allobaba.group.safarent_project.bean.appartementBean.PropAppartement;
import allobaba.group.safarent_project.dao.appartementDao.CategoriesAppartementDao;
import allobaba.group.safarent_project.service.facade.appartementService.CategoriesAppartementService;
import allobaba.group.safarent_project.ws.converter.appartementConverter.CategoriesAppartementConverter;
import allobaba.group.safarent_project.ws.dto.appartementDto.CategoriesAppartementDto;
import allobaba.group.safarent_project.ws.dto.appartementDto.PropAppartemenetDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CategoriesAppartementServiceImpl implements CategoriesAppartementService {
    private final CategoriesAppartementConverter categoriesAppartementConverter;
    private final CategoriesAppartementDao categoriesAppartementDao;

    public CategoriesAppartementServiceImpl(   CategoriesAppartementConverter categoriesAppartementConverter, CategoriesAppartementDao categoriesAppartementDao) {
        this.categoriesAppartementConverter = categoriesAppartementConverter;
        this.categoriesAppartementDao = categoriesAppartementDao;
    }
    @Override
    public int save(CategoriesAppartementDto categoriesAppartementDto) {

        CategoriesAppartement categoriesAppartement = categoriesAppartementConverter.toBean(categoriesAppartementDto);

        if (categoriesAppartement == null) {
            return -1;
        }

        if (categoriesAppartementDao.findByLibelle(categoriesAppartement.getLibelle()) != null) {
            return -2;
        }

       categoriesAppartementDao.save(categoriesAppartement);

        return 1;
    }

    @Override
    public List<CategoriesAppartement> findAll() {
        return categoriesAppartementDao.findAll();
    }

    @Override
    public int update(CategoriesAppartementDto categoriesAppartementDto) {
        if (categoriesAppartementDto == null) {
            return -1;
        }

        String libelle = categoriesAppartementDto.getLibelle();
        if (libelle == null || libelle.isEmpty()) {
            return -2;
        }

        CategoriesAppartement categoriesAppartement = categoriesAppartementDao.findByLibelle(libelle);
        if (categoriesAppartement == null) {
            return -3;
        }

        categoriesAppartement.setLibelle(categoriesAppartementDto.getLibelle());
        categoriesAppartementDao.save(categoriesAppartement);
        return 1;
    }

    @Override
    public CategoriesAppartement findByLibelle(String libelle) {
        return categoriesAppartementDao.findByLibelle(libelle);
    }

    @Transactional
    @Override
    public int deleteByLibelle(String libelle) {
        return categoriesAppartementDao.deleteByLibelle(libelle);
    }
}
