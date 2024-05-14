package org.sid.springsecurity.ws.facade.appartementWs;

import org.sid.springsecurity.bean.appartementBean.CategoriesAppartement;
import org.sid.springsecurity.service.facade.appartementService.CategoriesAppartementService;
import org.sid.springsecurity.ws.converter.appartementConverter.CategoriesAppartementConverter;
import org.sid.springsecurity.ws.dto.appartementDto.CategoriesAppartementDto;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoriesAppartemen/")
public class CategoriesAppartementWs {
    //mohammed ezzaim
    @PostMapping
    public int save(@RequestBody CategoriesAppartementDto categoriesAppartementDto) {
        CategoriesAppartement categoriesAppartement=categoriesAppartementConverter.toBean(categoriesAppartementDto);
        return categoriesAppartementService.save(categoriesAppartement);
    }

    @GetMapping
    public List<CategoriesAppartementDto> findAll() {
        return categoriesAppartementConverter.toDto(categoriesAppartementService.findAll());
    }

    @GetMapping("/libelle/{libelle}")
    public CategoriesAppartementDto findByLibelle(@PathVariable String libelle) {
        return categoriesAppartementConverter.toDto(categoriesAppartementService.findByLibelle(libelle));
    }

    @DeleteMapping("libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return categoriesAppartementService.deleteByLibelle(libelle);
    }

    @PutMapping
    public int update(@RequestBody UpdateCategories updateCategories) {
        return categoriesAppartementService.update(updateCategories.libelle,updateCategories.libelleNew);
    }

    private final CategoriesAppartementService categoriesAppartementService;
    private final CategoriesAppartementConverter categoriesAppartementConverter;

    public CategoriesAppartementWs(CategoriesAppartementService categoriesAppartementService, CategoriesAppartementConverter categoriesAppartementConverter) {
        this.categoriesAppartementService = categoriesAppartementService;
        this.categoriesAppartementConverter = categoriesAppartementConverter;
    }
}

class UpdateCategories{
  public   String libelle;
  public   String libelleNew;
}
