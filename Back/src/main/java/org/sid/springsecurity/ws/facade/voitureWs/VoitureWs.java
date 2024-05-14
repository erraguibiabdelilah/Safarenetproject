package org.sid.springsecurity.ws.facade.voitureWs;

import org.sid.springsecurity.bean.appartementBean.Appartement;
import org.sid.springsecurity.bean.photo.ImageModule;
import org.sid.springsecurity.bean.voitureBean.Voiture;
import org.sid.springsecurity.service.facade.voitureService.VoitureService;
import org.sid.springsecurity.ws.converter.voitureConverter.VoitureConverter;
import org.sid.springsecurity.ws.dto.appartementDto.AppartementDto;
import org.sid.springsecurity.ws.dto.voitureDto.VoitureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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






    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public @ResponseBody int save(@RequestPart("voiture") VoitureDto voitureDto,
                                  @RequestPart("imageFile") MultipartFile[] file) {
        try{
            Voiture voiture=converter.toBean(voitureDto);
            Set<ImageModule> images=uploadImage(file);
            voiture.setImages(images);
            return   voitureService.save(voiture);

        }catch(Exception e){
            System.out.println(e.getMessage());
            return -99;
        }
    }



    public Set<ImageModule> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModule> imageModuleSet=new HashSet<>();
        for(MultipartFile file :multipartFiles){
            ImageModule imageModule=new ImageModule(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes());
            imageModuleSet.add(imageModule);
        }
        return imageModuleSet;
    }


    @GetMapping("/images/{matricule}")
    public List<ImageModule> getProductImages(@PathVariable String matricule) {
        return voitureService.getImagesByProductMatricule(matricule);
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
