package allobaba.group.safarent_project.ws.facade.voitureWs;

import allobaba.group.safarent_project.bean.voitureBean.Voiture;
import allobaba.group.safarent_project.service.facade.voitureService.VoitureService;
import allobaba.group.safarent_project.ws.converter.voitureConverter.VoitureConverter;
import allobaba.group.safarent_project.ws.dto.voitureDto.VoitureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/safarent/manager/voiture/")

public class VoitureWs {
    @Autowired
    private VoitureService voitureService;

    @Autowired
    private VoitureConverter converter;

    @GetMapping
    public List<VoitureDto> findAll() {
        return converter.toDto(voitureService.findAll());
    }
    @GetMapping("matricule/{Matricule}")
    public VoitureDto findByMatricule(@PathVariable String Matricule) {
        return converter.toDto(voitureService.findByMatricule(Matricule));
    }
    @GetMapping("couleur/{couleur}")
    public List<VoitureDto> findByCouleur(@PathVariable String couleur) {
        return converter.toDto(voitureService.findByCouleur(couleur));
    }
    @GetMapping("boiteVitesse/{boiteVitesse}")
    public List<VoitureDto> findByBoitevitesse(@PathVariable String boiteVitesse) {
        return converter.toDto(voitureService.findByBoitevitesse(boiteVitesse));
    }
    @GetMapping("CategorieVoitureLibelle/{libelle}")
    public List<VoitureDto> findByCategorieVoitureLibelle(@PathVariable String libelle) {
        return converter.toDto(voitureService.findByCategorieVoitureLibelle(libelle));
    }
    @GetMapping("nameModele/{nom}")
    public List<VoitureDto> findByNomModele(@PathVariable String nom) {
        return converter.toDto(voitureService.findByNomModele(nom));
    }

    @PostMapping
    public int save(@RequestBody VoitureDto voitureDto) {

        Voiture voiture=converter.toBean(voitureDto);
        return voitureService.save(voiture);
    }
    @PutMapping
    public int update(@RequestBody  VoitureDto voitureDto) {
        Voiture voiture=converter.toBean(voitureDto);
        return voitureService.update(voiture);
    }

    @GetMapping("ville/{ville}")
    public List<VoitureDto> findByVille(@PathVariable String ville) {
        return converter.toDto(voitureService.findByVille(ville));
    }
    @DeleteMapping("matricule/{Matricule}")
    public int deleteByMatricule(@PathVariable String Matricule) {
        return voitureService.deleteByMatricule(Matricule);
    }
}
