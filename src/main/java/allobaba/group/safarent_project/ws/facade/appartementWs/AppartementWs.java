package allobaba.group.safarent_project.ws.facade.appartementWs;

import allobaba.group.safarent_project.service.facade.appartementService.AppartementService;
import allobaba.group.safarent_project.ws.converter.appartementConverter.AppartementConverter;
import allobaba.group.safarent_project.ws.dto.appartementDto.AppartementDto;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appartement/")
@CrossOrigin("*")
public class AppartementWs {
//mohammed
    public AppartementWs(AppartementService appartementService, AppartementConverter appartementConverter) {
        this.appartementService = appartementService;
        this.appartementConverter = appartementConverter;
    }

    @PostMapping
    public int save(@RequestBody  AppartementDto apparent) {
        return appartementService.save(apparent);
    }

    @GetMapping
    public List<AppartementDto> findAll() {
        return appartementConverter.toDto(appartementService.findAll());
    }


    @GetMapping("listAppartementCategories/{libelle}")
    public List<AppartementDto> findByCategoriesAppartementLibelle(@PathVariable String libelle) {
        return appartementConverter.toDto(appartementService.findByCategoriesAppartementLibelle(libelle));
    }

    @GetMapping("listAppartementCin/{cin}")
    public List<AppartementDto> findByPropAppartementCin(@PathVariable String cin) {
        return appartementConverter.toDto(appartementService.findByPropAppartementCin(cin));
    }

    @GetMapping("code/{code}")
    public AppartementDto findByCode(String  code) {
        return appartementConverter.toDto(appartementService.findByCode(code));
    }

    @Transactional
    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return appartementService.deleteByCode(code);
    }

    @PutMapping
    public int update(AppartementDto appartementDto) {
        return appartementService.update(appartementDto);
    }

    private final AppartementService appartementService;

    private  final AppartementConverter appartementConverter;
}
