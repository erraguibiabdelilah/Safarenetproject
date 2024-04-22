package org.sid.springsecurity.ws.facade.communWs;
import org.sid.springsecurity.bean.communBean.Location;
import org.sid.springsecurity.service.facade.communService.LocationService;
import org.sid.springsecurity.ws.converter.communConverter.LocationConverter;
import org.sid.springsecurity.ws.dto.communDto.LocationDto;
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
