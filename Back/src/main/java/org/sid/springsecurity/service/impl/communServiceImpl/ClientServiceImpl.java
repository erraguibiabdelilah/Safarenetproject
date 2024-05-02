package org.sid.springsecurity.service.impl.communServiceImpl;


import org.sid.springsecurity.bean.appartementBean.PropAppartement;
import org.sid.springsecurity.bean.communBean.Client;
import org.sid.springsecurity.bean.voitureBean.AgenceLocation;
import org.sid.springsecurity.dao.communDao.ClientDao;
import org.sid.springsecurity.security.bean.AppRole;
import org.sid.springsecurity.security.dao.AppRoleDao;
import org.sid.springsecurity.service.facade.appartementService.PropAppartementService;
import org.sid.springsecurity.service.facade.communService.ClientService;
import org.sid.springsecurity.service.facade.voitureService.AgenceLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AppRoleDao appRoleDao;

    public ClientServiceImpl(ClientDao clientDao ) {
        this.clientDao = clientDao;



    }

    @Override
    public int save(Client client) {
        System.out.println("********************************************************************************************");
        System.out.println(client.getCin());
        System.out.println(client.getUsername());
        System.out.println(client.getPassword());
        System.out.println("********************************************************************************************");
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
        String pw=client.getPassword();
        if (pw.isEmpty()) {
            return -3;
        }
        client.setPassword(passwordEncoder.encode(pw));
        AppRole appRole=appRoleDao.findByRoleName("USER");
        client.getAppRoles().add(appRole);
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

        if (existingClient == null) {
            return -1;
        }

        try {
            if (client.getProp_appartement() == null && client.getAgence_Location() == null) {
                return -2;
            }

            PropAppartement propAppartement = propAppartementService.findByCin(client.getProp_appartement().getCin());
            AgenceLocation agenceLocation = agenceLocationService.findByiceAgLoc(client.getAgence_Location().getIceAgLoc());


            existingClient.setPrenom(client.getPrenom());
            existingClient.setNom(client.getNom());
            existingClient.setEmailClient(client.getEmailClient());
            existingClient.setNumTeleClient(client.getNumTeleClient());
            existingClient.setCin(client.getCin());
            existingClient.setProp_appartement(propAppartement);
            existingClient.setAgence_Location(agenceLocation);



            clientDao.save(existingClient);

            return 1;

        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de paiement : " + e.getMessage());
            e.printStackTrace();
            return -4;
        }
    }

    @Override
    public int deleteByCin(String cin) {
        return clientDao.deleteByCin(cin);
    }


    @Override
    public Client findByUsername(String username) {
        return clientDao.findByUsername(username);
    }

}
