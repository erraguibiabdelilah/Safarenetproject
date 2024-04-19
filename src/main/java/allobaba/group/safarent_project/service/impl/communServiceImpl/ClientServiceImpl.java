package allobaba.group.safarent_project.service.impl.communServiceImpl;


import allobaba.group.safarent_project.bean.appartementBean.PropAppartement;
import allobaba.group.safarent_project.bean.communBean.Client;
import allobaba.group.safarent_project.bean.voitureBean.AgenceLocation;
import allobaba.group.safarent_project.dao.communDao.ClientDao;
import allobaba.group.safarent_project.service.facade.appartementService.PropAppartementService;
import allobaba.group.safarent_project.service.facade.communService.ClientService;
import allobaba.group.safarent_project.service.facade.voitureService.AgenceLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Lazy
@Service
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;




    @Autowired
    private PropAppartementService propAppartementService;
    @Autowired
    private AgenceLocationService agenceLocationService;


    public ClientServiceImpl(ClientDao clientDao ) {
        this.clientDao = clientDao;



    }

    @Override
    public int save(Client client) {
        Long iceAgLoc =null;
        String cin = "";
        if (client == null) {
            System.out.println("null");
            return -1;
        }
        if (clientDao.findByCin(client.getCin()) != null) {
            System.out.println("deja existed");
            return -2;
        }
        if (client.getAgence_Location() != null || client.getProp_appartement() != null) {
            iceAgLoc = client.getAgence_Location().getIceAgLoc();
            cin = client.getProp_appartement().getCin();

        }
        AgenceLocation agenceLocation = agenceLocationService.findByiceAgLoc(iceAgLoc);
        PropAppartement propAppartement = propAppartementService.findByCin(cin);


        if (agenceLocation != null || propAppartement != null) {
            client.setAgence_Location(agenceLocation);
            client.setProp_appartement(propAppartement);

        } else {
            client.setAgence_Location(null);
            client.setProp_appartement(null);
        }
        clientDao.save(client);


        return 1;
    }

    @Override
    public Client findByCin(String cin) {
        return (clientDao.findByCin(cin));
    }

    @Override
    public List<Client> findAll() {
        return (clientDao.findAll());
    }

    @Override
    public int update(Client client) {

        Client existingClient = findByCin(client.getCin());

        if (client == null) {
            return -1;
        }

        try {
            if (client.getProp_appartement() == null || client.getAgence_Location() == null) {
                return -2;
            }
            if (client.getProp_appartement().getCin() == null || client.getAgence_Location().getIceAgLoc() == null) {
                return -3;
            }
            PropAppartement propAppartement = propAppartementService.findByCin(client.getProp_appartement().getCin());
            AgenceLocation agenceLocation = agenceLocationService.findByiceAgLoc(client.getAgence_Location().getIceAgLoc());


            client.setReservation(client.getReservation());
            client.setEmailClient(client.getEmailClient());
            client.setPrenom(client.getPrenom());
            client.setNom(client.getNom());
            client.setNumTeleClient(client.getNumTeleClient());
            client.setUsernameClient(client.getUsernameClient());
            client.setAgence_Location(client.getAgence_Location());
            client.setProp_appartement(client.getProp_appartement());


            clientDao.save(client);

            return 1;

        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de client : " + e.getMessage());
            e.printStackTrace();
            return -4;
        }
    }

    @Override
    public int deleteByCin(String cin) {
        return clientDao.deleteByCin(cin);
    }


}
