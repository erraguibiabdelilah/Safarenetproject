package allobaba.group.safarent_project.ws.facade.communWs;

import allobaba.group.safarent_project.bean.communBean.Client;
import allobaba.group.safarent_project.bean.communBean.Paiement;
import allobaba.group.safarent_project.service.facade.communService.PaiementService;
import allobaba.group.safarent_project.ws.converter.communConverter.PaiementConverter;
import allobaba.group.safarent_project.ws.dto.appartementDto.AppartementDto;
import allobaba.group.safarent_project.ws.dto.communDto.ClientDto;
import allobaba.group.safarent_project.ws.dto.communDto.PaiementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiement/")
public class PaiementWs {
    private PaiementService paiementService;
    @Autowired
    private PaiementConverter converter;

    public PaiementWs(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping
    public int save(@RequestBody PaiementDto paiementDto) {
       Paiement paiement = converter.toBean(paiementDto);
        return paiementService.save(paiement);
    }

    @GetMapping("ref/{ref}")
    public PaiementDto findByRef(@PathVariable String ref) {
        return converter.toDto(paiementService.findByRef(ref));
    }


    @GetMapping
    public List<PaiementDto> findAll() {
        return converter.toDto(paiementService.findAll());
    }
    @PutMapping
    public int update(@RequestBody PaiementDto paiementDto) {
        Paiement paiement= converter.toBean(paiementDto);
        return paiementService.update(paiement);
    }

    @Transactional
    @DeleteMapping("ref/{ref}")
    public int deleteByRef(String ref) {
        return paiementService.deleteByRef(ref);
    }
}
