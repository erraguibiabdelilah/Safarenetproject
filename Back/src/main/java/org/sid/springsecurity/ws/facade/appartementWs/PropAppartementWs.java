package org.sid.springsecurity.ws.facade.appartementWs;

import org.sid.springsecurity.bean.appartementBean.PropAppartement;
import org.sid.springsecurity.bean.voitureBean.AgenceLocation;
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
    public int save(@RequestBody PropAppartemenetDto propAppartemenetDto) {
        return propAppartementService.save(propAppartemenetConverter.toBean(propAppartemenetDto));
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
    public int update(@RequestBody PropAppartemenetDto propAppartemenetDto) {
        PropAppartement propAppartement = propAppartemenetConverter.toBean(propAppartemenetDto);
        return propAppartementService.update(propAppartement);
    }


    @GetMapping("/username/{username}")
    public PropAppartement findByUsername(@PathVariable  String username) {
        return propAppartementService.findByUsername(username);
    }


    private final PropAppartementService propAppartementService;
    private final PropAppartemenetConverter propAppartemenetConverter;

    public PropAppartementWs(PropAppartementService propAppartementService, PropAppartemenetConverter propAppartemenetConverter) {
        this.propAppartementService = propAppartementService;
        this.propAppartemenetConverter = propAppartemenetConverter;
    }
}
