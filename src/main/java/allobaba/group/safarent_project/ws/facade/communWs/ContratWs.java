package allobaba.group.safarent_project.ws.facade.communWs;

import allobaba.group.safarent_project.bean.communBean.Contrat;
import allobaba.group.safarent_project.service.facade.communService.ContratService;
import allobaba.group.safarent_project.ws.converter.communConverter.ContratConverter;
import allobaba.group.safarent_project.ws.dto.communDto.ContratDto;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrat/")
public class ContratWs {
    public ContratWs(ContratService contratService, ContratConverter contratConverter) {
        this.contratService = contratService;
        this.contratConverter = contratConverter;
    }

    @PostMapping
    public int save(@RequestBody ContratDto contratDto) {
        Contrat contrat = contratConverter.toBean(contratDto);
        return contratService.save(contrat);

    }
    @GetMapping("numContrat/{numContrat}")
    public ContratDto findByNumContrat(@PathVariable int numContrat) {
        return contratConverter.toDto(contratService.findByNumContrat(numContrat));
    }
    @GetMapping
    public List<ContratDto> findAll() {
        return contratConverter.toDto(contratService.findAll());
    }
    @Transactional
    @DeleteMapping("numContrat/{numContrat}")
    public int deleteByNumContrat(@PathVariable int numContrat) {
        return contratService.deleteByNumContrat(numContrat);
    }
    @PutMapping
    public int update(@RequestBody ContratDto contratDto) {
        Contrat contrat = contratConverter.toBean(contratDto);
        return contratService.update(contrat);
}

    private ContratService contratService ;
    private ContratConverter contratConverter ;


}
