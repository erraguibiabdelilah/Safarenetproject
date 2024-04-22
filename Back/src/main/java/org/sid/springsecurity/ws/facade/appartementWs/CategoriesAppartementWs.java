package org.sid.springsecurity.ws.facade.appartementWs;

import org.sid.springsecurity.service.facade.appartementService.CategoriesAppartementService;
import org.sid.springsecurity.ws.converter.appartementConverter.CategoriesAppartementConverter;
import org.sid.springsecurity.ws.dto.appartementDto.CategoriesAppartementDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoriesAppartemen/")
@CrossOrigin("*")
public class CategoriesAppartementWs {
    //mohammed ezzaim
    @PostMapping
    public int save(@RequestBody CategoriesAppartementDto categoriesAppartementDto) {
        return categoriesAppartementService.save(categoriesAppartementDto);
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
