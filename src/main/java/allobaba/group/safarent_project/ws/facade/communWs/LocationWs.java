package allobaba.group.safarent_project.ws.facade.communWs;

import allobaba.group.safarent_project.bean.communBean.Facture;
import allobaba.group.safarent_project.bean.communBean.Location;
import allobaba.group.safarent_project.service.facade.communService.LocationService;
import allobaba.group.safarent_project.ws.converter.communConverter.LocationConverter;
import allobaba.group.safarent_project.ws.dto.communDto.FactureDto;
import allobaba.group.safarent_project.ws.dto.communDto.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location/")
public class LocationWs {
    public LocationWs(LocationService locationService, LocationConverter locationConverter) {
        this.locationService = locationService;
        this.locationConverter = locationConverter;
    }
    @PostMapping
    public int save(@RequestBody LocationDto locationDto) {
        Location location =locationConverter.toBean(locationDto);
        return locationService.save(location);
    }
    @GetMapping
    public List<LocationDto> findAll() {
        return locationConverter.toDto(locationService.findAll());
    }
    @GetMapping("ref/{ref}")
    public LocationDto findByRef(@PathVariable String ref) {
        return locationConverter.toDto(locationService.findByRef(ref));
    }
    @Transactional
    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return locationService.deleteByRef(ref);
    }

    @PutMapping
    public int update(@RequestBody LocationDto locationDto) {
        Location location = locationConverter.toBean(locationDto);
        return locationService.update(location);
    }
    private LocationService locationService ;
    private LocationConverter locationConverter ;


}
