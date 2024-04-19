package allobaba.group.safarent_project.ws.facade.appartementWs;

import allobaba.group.safarent_project.service.facade.appartementService.CategoriesAppartementService;
import allobaba.group.safarent_project.ws.converter.appartementConverter.CategoriesAppartementConverter;
import allobaba.group.safarent_project.ws.dto.appartementDto.CategoriesAppartementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public int update(@RequestBody CategoriesAppartementDto categoriesAppartementDto) {
        return categoriesAppartementService.update(categoriesAppartementDto);
    }

    private final CategoriesAppartementService categoriesAppartementService;
    private final CategoriesAppartementConverter categoriesAppartementConverter;

    public CategoriesAppartementWs(CategoriesAppartementService categoriesAppartementService, CategoriesAppartementConverter categoriesAppartementConverter) {
        this.categoriesAppartementService = categoriesAppartementService;
        this.categoriesAppartementConverter = categoriesAppartementConverter;
    }
}
