package allobaba.group.safarent_project.ws.facade.communWs;

import allobaba.group.safarent_project.bean.communBean.Client;
import allobaba.group.safarent_project.service.facade.communService.ClientService;
import allobaba.group.safarent_project.ws.converter.communConverter.ClientConverter;
import allobaba.group.safarent_project.ws.dto.appartementDto.AppartementDto;
import allobaba.group.safarent_project.ws.dto.communDto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/")
public class ClientWs {
    private ClientService clientService;
    @Autowired
    private ClientConverter converter ;

    public ClientWs(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public int save(@RequestBody ClientDto clientDto) {
        Client client =converter.toBean(clientDto);
        return clientService.save(client);
    }

    @GetMapping("cin/{cin}")
    public ClientDto findByCin(@PathVariable String cin) {
        return converter.toDto(clientService.findByCin(cin));
    }

    @GetMapping
    public List<ClientDto> findAll() {
        return converter.toDto(clientService.findAll());
    }

    @PutMapping
    public int update(@RequestBody ClientDto clientDto) {
        Client client= converter.toBean(clientDto);
       return clientService.update(client);
    }

    @Transactional
    @DeleteMapping("cin/{cin}")
    public int deleteByCin(String cin) {
        return clientService.deleteByCin(cin);
    }


}
