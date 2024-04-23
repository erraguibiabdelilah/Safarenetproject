package org.sid.springsecurity.service.impl.appartementServiceImpl;

import org.sid.springsecurity.bean.appartementBean.Appartement;
import org.sid.springsecurity.bean.appartementBean.PropAppartement;
import org.sid.springsecurity.bean.communBean.Client;
import org.sid.springsecurity.bean.communBean.Paiement;
import org.sid.springsecurity.dao.appartementDao.PropAppartementDao;
import org.sid.springsecurity.security.bean.AppRole;
import org.sid.springsecurity.security.dao.AppRoleDao;
import org.sid.springsecurity.service.facade.appartementService.PropAppartementService;
import org.sid.springsecurity.ws.converter.appartementConverter.PropAppartemenetConverter;
import org.sid.springsecurity.ws.dto.appartementDto.PropAppartemenetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PropAppartementServiceImpl implements PropAppartementService {
    private final PropAppartementDao propAppartementDao;
    private final PropAppartemenetConverter propAppartemenetConverter;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AppRoleDao appRoleDao;
    public PropAppartementServiceImpl( PropAppartementDao propAppartementDao,  PropAppartemenetConverter propAppartemenetConverter) {
        this.propAppartementDao = propAppartementDao;
        this.propAppartemenetConverter = propAppartemenetConverter;
    }
    @Override
    public int save(PropAppartement propAppartement) {

        if(propAppartement==null){
            return  -1;
        }

        else if (propAppartementDao.findByCin(propAppartement.getCin())!=null) {
            return  -2;
        }
        else {
            List<Client> clients=propAppartement.getClients();
            List<Paiement> paiements=propAppartement.getPaiements();
            List<Appartement> appartements=propAppartement.getAppartementList();
            if(clients!=null){
                propAppartement.setClients(clients);
            }
            if(paiements!=null){
                propAppartement.setPaiements(paiements);
            }
            if(appartements!=null){
                propAppartement.setAppartementList(appartements);
            }
        }
        String pw=propAppartement.getPassword();
        if (pw.isEmpty()) {
            return -3;
        }
        propAppartement.setPassword(passwordEncoder.encode(pw));
        AppRole appRole=appRoleDao.findByRoleName("MANAGER-APT");
        propAppartement.getAppRoles().add(appRole);
      propAppartemenetConverter.toDto(propAppartementDao.save(propAppartement));
        return 1;
    }
    @Override
    public List<PropAppartement> findAll() {
        return propAppartementDao.findAll();
    }

    @Override
    public int update(PropAppartemenetDto propAppartemenetDto) {
        if (propAppartemenetDto == null) {
            return -1;
        }

        String cin = propAppartemenetDto.getCin();
        if (cin == null || cin.isEmpty()) {
            return -2;
        }

        PropAppartement propAppartement = propAppartementDao.findByCin(cin);
        if (propAppartement == null) {
            return -3;
        }

        propAppartement.setNom(propAppartemenetDto.getNom());
        propAppartement.setPrenom(propAppartemenetDto.getPrenom());
        propAppartement.setNumTele(propAppartemenetDto.getNumTele());
        propAppartement.setEmail(propAppartemenetDto.getEmail());

        propAppartement.setRibPropAppt(propAppartemenetDto.getRibPropAppt());
        propAppartement.setNumCompteBkPropApp(propAppartemenetDto.getNumCompteBkPropApp());
        propAppartement.setCin(propAppartemenetDto.getCin());
        propAppartement.setUsername(propAppartemenetDto.getUsernamePropAppt());

        propAppartementDao.save(propAppartement);
        return 1;
    }


    @Override
    public PropAppartement findByCin(String cin) {
        return propAppartementDao.findByCin(cin);
    }

    @Transactional
    @Override
    public int deleteByCin(String cin) {
        return propAppartementDao.deleteByCin(cin);
    }


}
