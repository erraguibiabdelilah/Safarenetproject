package org.sid.springsecurity.ws.facade.voitureWs;


import org.sid.springsecurity.bean.voitureBean.CategorieVoiture;
import org.sid.springsecurity.service.facade.voitureService.CategorieVoitureService;
import org.sid.springsecurity.ws.converter.voitureConverter.CategorieVoitureConverter;
import org.sid.springsecurity.ws.dto.voitureDto.CategorieVoitureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/safarent/manager/categorieVoiture/")


public class CategorieVoitureWs {

    @Autowired
    private CategorieVoitureService categorieVoitureService;

    @Autowired
    private CategorieVoitureConverter converter;

    @GetMapping("libelle/{libelle}")
    public CategorieVoitureDto findByLibelle(@PathVariable String libelle) {
        return converter.toDto(categorieVoitureService.findByLibelle(libelle));
    }
    @PostMapping
    public int save(@RequestBody CategorieVoitureDto categorieVoitureDto) {
        CategorieVoiture categorieVoiture=converter.toBean(categorieVoitureDto);
        return categorieVoitureService.save(categorieVoiture);
    }

    @GetMapping("")
    public List<CategorieVoitureDto> findAll() {
        return converter.toDto(categorieVoitureService.findAll());
    }
    @DeleteMapping("libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return categorieVoitureService.deleteByLibelle(libelle);
    }
}
