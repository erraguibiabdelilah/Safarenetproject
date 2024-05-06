package org.sid.springsecurity.ws.facade.appartementWs;

import org.sid.springsecurity.bean.appartementBean.Appartement;
import org.sid.springsecurity.bean.photo.ImageModule;
import org.sid.springsecurity.service.facade.appartementService.AppartementService;
import org.sid.springsecurity.ws.converter.appartementConverter.AppartementConverter;
import org.sid.springsecurity.ws.dto.appartementDto.AppartementDto;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/appartement/")
public class AppartementWs {
//mohammed ezzaim
    public AppartementWs(AppartementService appartementService, AppartementConverter appartementConverter) {
        this.appartementService = appartementService;
        this.appartementConverter = appartementConverter;
    }



    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public @ResponseBody int save(@RequestPart("apartment") AppartementDto appartementDto,
                                      @RequestPart("imageFile")MultipartFile[] file) {
        try{
            System.out.println("appartemetDto:"+appartementDto);
            Appartement appartement=appartementConverter.toBean(appartementDto);
            System.out.println("appartement:"+appartementDto);
            Set<ImageModule> images=uploadImage(file);
            appartement.setImages(images);
            return   appartementService.save(appartement);

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


    @GetMapping("/images/{code}")
    public List<ImageModule> getProductImages(@PathVariable String code) {
        return appartementService.getImagesByProductRef(code);
    }



    @PostMapping("appartement")
    public int save(@RequestBody AppartementDto appartementDto) {
        return appartementService.save(appartementConverter.toBean(appartementDto));
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
    public AppartementDto findByCode(@PathVariable String  code) {
        return appartementConverter.toDto(appartementService.findByCode(code));
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return appartementService.deleteByCode(code);
    }

    @PutMapping
    public int update(@RequestBody  AppartementDto appartementDto) {
        return appartementService.update(appartementConverter.toBean(appartementDto));
    }

    @GetMapping("/adresse/{adresse}")
    public List<Appartement> findByAdresse(@PathVariable String adresse){
        return appartementService.findByAdresse(adresse);
    }
    @GetMapping("/LoyerMensuel/{mont}")
    public List<Appartement> findByLoyerMensuelLessThanEqual(@PathVariable double mont ){
        return appartementService.findByLoyerMensuelLessThanEqual(mont);
    }
    private final AppartementService appartementService;

    private  final AppartementConverter appartementConverter;
}
