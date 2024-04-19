package allobaba.group.safarent_project.service.facade.communService;

import allobaba.group.safarent_project.bean.communBean.Client;
import allobaba.group.safarent_project.ws.dto.communDto.ClientDto;
import allobaba.group.safarent_project.ws.dto.communDto.ReservationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {
    int save(Client client);

    Client findByCin(String cin);

    List<Client> findAll();

    int update(Client client);

    int deleteByCin(String cin);

}
