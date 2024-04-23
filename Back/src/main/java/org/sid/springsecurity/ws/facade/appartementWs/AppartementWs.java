package org.sid.springsecurity.ws.facade.appartementWs;

import org.sid.springsecurity.service.facade.appartementService.AppartementService;
import org.sid.springsecurity.ws.converter.appartementConverter.AppartementConverter;
import org.sid.springsecurity.ws.dto.appartementDto.AppartementDto;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appartement/")
public class AppartementWs {
//mohammed ezzaim
    public AppartementWs(AppartementService appartementService, AppartementConverter appartementConverter) {
        this.appartementService = appartementService;
        this.appartementConverter = appartementConverter;
    }

    @PostMapping
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public int save(@RequestBody AppartementDto apparent) {
        return appartementService.save(appartementConverter.toBean(apparent));
    }

    @GetMapping
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public List<AppartementDto> findAll() {
        return appartementConverter.toDto(appartementService.findAll());
    }


    @GetMapping("listAppartementCategories/{libelle}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public List<AppartementDto> findByCategoriesAppartementLibelle(@PathVariable String libelle) {
        return appartementConverter.toDto(appartementService.findByCategoriesAppartementLibelle(libelle));
    }

    @GetMapping("listAppartementCin/{cin}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public List<AppartementDto> findByPropAppartementCin(@PathVariable String cin) {
        return appartementConverter.toDto(appartementService.findByPropAppartementCin(cin));
    }

    @GetMapping("code/{code}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public AppartementDto findByCode(@PathVariable String  code) {
        return appartementConverter.toDto(appartementService.findByCode(code));
    }

    @DeleteMapping("code/{code}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public int deleteByCode(@PathVariable String code) {
        return appartementService.deleteByCode(code);
    }

    @PutMapping
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public int update(@RequestBody  AppartementDto appartementDto) {
        return appartementService.update(appartementConverter.toBean(appartementDto));
    }

    private final AppartementService appartementService;

    private  final AppartementConverter appartementConverter;
}
