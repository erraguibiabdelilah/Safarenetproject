package allobaba.group.safarent_project.ws.facade.appartementWs;

import allobaba.group.safarent_project.bean.appartementBean.PropAppartement;
import allobaba.group.safarent_project.service.facade.appartementService.PropAppartementService;
import allobaba.group.safarent_project.ws.converter.appartementConverter.PropAppartemenetConverter;
import allobaba.group.safarent_project.ws.dto.appartementDto.PropAppartemenetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propAppartement/")
@CrossOrigin("*")
public class PropAppartementWs {
    //mohammed  ezzaim
    @PostMapping
    public int save(@RequestBody PropAppartement appartement) {
        return propAppartementService.save(appartement);
    }

    @GetMapping
    public List<PropAppartemenetDto> findAll() {
        return propAppartemenetConverter.toDto(propAppartementService.findAll());
    }

    @GetMapping("cin/{cin}")
    public PropAppartemenetDto findByCin(@PathVariable String cin) {
        return propAppartemenetConverter.toDto(propAppartementService.findByCin(cin));
    }

    @DeleteMapping("cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return propAppartementService.deleteByCin(cin);
    }

    @PutMapping
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
