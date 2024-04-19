package allobaba.group.safarent_project.service.impl.appartementServiceImpl;
import allobaba.group.safarent_project.bean.appartementBean.Appartement;
import allobaba.group.safarent_project.bean.appartementBean.PropAppartement;
import allobaba.group.safarent_project.bean.communBean.Client;
import allobaba.group.safarent_project.bean.communBean.Paiement;
import allobaba.group.safarent_project.dao.appartementDao.PropAppartementDao;
import allobaba.group.safarent_project.service.facade.appartementService.PropAppartementService;
import allobaba.group.safarent_project.ws.converter.appartementConverter.PropAppartemenetConverter;
import allobaba.group.safarent_project.ws.dto.appartementDto.PropAppartemenetDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PropAppartementServiceImpl implements PropAppartementService {
    private final PropAppartementDao propAppartementDao;
    private final PropAppartemenetConverter propAppartemenetConverter;
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
        propAppartement.setUsernamePropAppt(propAppartemenetDto.getCin());

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
