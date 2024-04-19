package allobaba.group.safarent_project.service.facade.communService;

import allobaba.group.safarent_project.bean.communBean.Contrat;
import allobaba.group.safarent_project.ws.dto.communDto.ClientDto;
import allobaba.group.safarent_project.ws.dto.communDto.ContratDto;
import allobaba.group.safarent_project.ws.dto.communDto.ReservationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContratService {
    int save(Contrat contrat);
    Contrat findByNumContrat(int numContrat);
    List<Contrat> findAll();
    int deleteByNumContrat(int numContrat);
    int update(Contrat contrat);
}
