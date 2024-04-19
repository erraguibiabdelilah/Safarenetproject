package allobaba.group.safarent_project.ws.facade.communWs;

import allobaba.group.safarent_project.bean.communBean.Reservation;
import allobaba.group.safarent_project.service.facade.communService.ReservationService;
import allobaba.group.safarent_project.ws.converter.communConverter.ReservationConverter;
import allobaba.group.safarent_project.ws.dto.communDto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/safarent/manager/reservation/")

public class ReservationWs {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ReservationConverter converter;

    @GetMapping("ref/{ref}")
    public ReservationDto findByRef(@PathVariable String ref) {
        return converter.toDto(reservationService.findByRef(ref));
    }
    @GetMapping
    public List<ReservationDto> findAll() {
        return converter.toDto(reservationService.findAll());
    }
    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return reservationService.deleteByRef(ref);
    }
    @GetMapping("VoitureMatricule/{matricule}")
    public ReservationDto findByVoitureMatricule(@PathVariable String matricule) {
        return converter.toDto(reservationService.findByVoitureMatricule(matricule));
    }
    @GetMapping("AppartementCode/{code}")
    public ReservationDto findByAppartementCode(@PathVariable String code) {
        return converter.toDto(reservationService.findByAppartementCode(code));
    }
    @PostMapping
    public int save(@RequestBody ReservationDto reservationDto) {
      Reservation reservation =converter.toBean(reservationDto);
        return reservationService.save(reservation);
    }
    @GetMapping("clientCin/{cin}")
    public List<ReservationDto> findAllByClientCin(@PathVariable String cin) {
        return converter.toDto(reservationService.findAllByClientCin(cin));
    }

    @GetMapping("LocationsRef/{ref}")
    public ReservationDto findByLocationsRef(@PathVariable String ref) {
        return converter.toDto(reservationService.findByLocationsRef(ref));
    }
}
