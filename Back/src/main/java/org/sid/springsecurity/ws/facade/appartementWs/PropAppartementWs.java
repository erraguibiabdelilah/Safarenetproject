package org.sid.springsecurity.ws.facade.appartementWs;

import org.sid.springsecurity.bean.appartementBean.PropAppartement;
import org.sid.springsecurity.service.facade.appartementService.PropAppartementService;
import org.sid.springsecurity.ws.converter.appartementConverter.PropAppartemenetConverter;
import org.sid.springsecurity.ws.dto.appartementDto.PropAppartemenetDto;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propAppartement/")
public class PropAppartementWs {
    //mohammed  ezzaim
    @PostMapping

    public int save(@RequestBody PropAppartement appartement) {
        return propAppartementService.save(appartement);
    }

    @GetMapping
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public List<PropAppartemenetDto> findAll() {
        return propAppartemenetConverter.toDto(propAppartementService.findAll());
    }

    @GetMapping("cin/{cin}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public PropAppartemenetDto findByCin(@PathVariable String cin) {
        return propAppartemenetConverter.toDto(propAppartementService.findByCin(cin));
    }

    @DeleteMapping("cin/{cin}")
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public int deleteByCin(@PathVariable String cin) {
        return propAppartementService.deleteByCin(cin);
    }

    @PutMapping
    @PostAuthorize("hasAnyAuthority('ADMIN')")
    public void update(@RequestBody PropAppartemenetDto propAppartemenetDto) {
        propAppartementService.update(propAppartemenetDto);
    }

    private final PropAppartementService propAppartementService;
    private final PropAppartemenetConverter propAppartemenetConverter;

    public PropAppartementWs(PropAppartementService propAppartementService, PropAppartemenetConverter propAppartemenetConverter) {
        this.propAppartementService = propAppartementService;
        this.propAppartemenetConverter = propAppartemenetConverter;
    }
}
