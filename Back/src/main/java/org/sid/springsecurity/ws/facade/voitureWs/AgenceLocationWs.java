package org.sid.springsecurity.ws.facade.voitureWs;

import org.sid.springsecurity.bean.voitureBean.AgenceLocation;
import org.sid.springsecurity.service.facade.voitureService.AgenceLocationService;
import org.sid.springsecurity.ws.converter.voitureConverter.AgenceLocationConverter;
import org.sid.springsecurity.ws.dto.voitureDto.AgenceLocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agenceLocation/")
public class AgenceLocationWs {
    private AgenceLocationService agenceLocationService;
    @Autowired
    private AgenceLocationConverter converter ;

    public AgenceLocationWs(AgenceLocationService agenceLocationService) {
        this.agenceLocationService = agenceLocationService;
    }

    @PostMapping
    public int save(@RequestBody AgenceLocationDto agenceLocationDto) {
        AgenceLocation agenceLocation = converter.toBean(agenceLocationDto);
        return agenceLocationService.save(agenceLocation);
    }
    @GetMapping("iceAgLoc/{iceAgLoc}")
    public AgenceLocationDto findByiceAgLoc(@PathVariable Long iceAgLoc)  {
        return converter.toDto(agenceLocationService.findByiceAgLoc(iceAgLoc));
    }
    @GetMapping
    public List<AgenceLocationDto> findAll() {
        return converter.toDto(agenceLocationService.findAll());
    }
    @PutMapping
    public int update(@RequestBody AgenceLocationDto agenceLocationDto ) {
        AgenceLocation agenceLocation = converter.toBean(agenceLocationDto);
       return agenceLocationService.update(agenceLocation);
    }

    @Transactional
    @DeleteMapping("iceAgLoc/{iceAgLoc}")
    public int deleteByiceAgLoc(Long  iceAgLoc) {
        return agenceLocationService.deleteByiceAgLoc(iceAgLoc);
    }
}
