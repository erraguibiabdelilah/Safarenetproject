package org.sid.springsecurity.ws.facade.voitureWs;

import org.sid.springsecurity.bean.appartementBean.AgenceAppartement;
import org.sid.springsecurity.bean.photo.ImageModule;
import org.sid.springsecurity.bean.voitureBean.AgenceLocation;
import org.sid.springsecurity.service.facade.voitureService.AgenceLocationService;
import org.sid.springsecurity.ws.converter.voitureConverter.AgenceLocationConverter;
import org.sid.springsecurity.ws.dto.appartementDto.AgenceAppartementDto;
import org.sid.springsecurity.ws.dto.voitureDto.AgenceLocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    @Transactional
    @DeleteMapping("iceAgLoc/{iceAgLoc}")
    public int deleteByiceAgLoc(@PathVariable  Long  iceAgLoc) {
        return agenceLocationService.deleteByIceAgLoc(iceAgLoc);
    }

    @GetMapping("/username/{username}")
    public AgenceLocation findByUsername(@PathVariable  String username) {
        return agenceLocationService.findByUsername(username);
    }


    //logo************************************************************************
    @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int update(
            @RequestPart("agenceLocation") AgenceLocationDto agenceLocationDto,
            @RequestPart("logo") MultipartFile[] file
    )
    {
        try {
            AgenceLocation agenceLocation=converter.toBean(agenceLocationDto);
            Set<ImageModule> logo = uploadImage(file);
            agenceLocation.setLogo(logo);
            return agenceLocationService.update(agenceLocation);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("-9999999");
            return -99999;
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

    @GetMapping("/images/{username}")
    public List<ImageModule> getProductImages(@PathVariable String username) {
        return agenceLocationService.getImagesByIceAgLoc(username);
    }
    //logo************************************************************************

}
