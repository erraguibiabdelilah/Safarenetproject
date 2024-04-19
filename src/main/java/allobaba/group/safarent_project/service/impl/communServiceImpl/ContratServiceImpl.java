package allobaba.group.safarent_project.service.impl.communServiceImpl;

import allobaba.group.safarent_project.bean.communBean.Contrat;
import allobaba.group.safarent_project.bean.communBean.Location;
import allobaba.group.safarent_project.dao.communDao.ContratDao;
import allobaba.group.safarent_project.dao.communDao.LocationDao;
import allobaba.group.safarent_project.service.facade.communService.ContratService;
import allobaba.group.safarent_project.service.facade.communService.LocationService;
import allobaba.group.safarent_project.ws.converter.communConverter.ContratConverter;
import allobaba.group.safarent_project.ws.converter.communConverter.LocationConverter;
import allobaba.group.safarent_project.ws.dto.communDto.ClientDto;
import allobaba.group.safarent_project.ws.dto.communDto.ContratDto;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ContratServiceImpl implements ContratService {
    private ContratDao contratDao ;
    private LocationService locationService;

    public ContratServiceImpl(ContratDao contratDao,@Lazy LocationService locationService) {
        this.contratDao = contratDao;
        this.locationService = locationService;
    }

    @Override
    public int save(Contrat contrat) {
        if (contrat == null) {
            System.out.println("Contrat null");
            return -1;
        }
        if (findByNumContrat(contrat.getNumContrat()) != null) {
            System.out.println("contrat (numContrat) deja existed");
            return -2;
        }

        Location location = locationService.findByRef(contrat.getLocation().getRef());

        if (location == null) {
            System.out.println("location est null");
            return -3;
        }
        if (locationService.findByRef(location.getRef()) == null) {
            System.out.println("Cette location n'existe pas");
            return -4;
        }

        contrat.setLocation(location);
        contratDao.save(contrat);
        return 1;
    }

    @Override
    public Contrat findByNumContrat(int numContrat) {
        return contratDao.findByNumContrat(numContrat);
    }

    @Override
    public List<Contrat> findAll() {
        return contratDao.findAll();
    }

    @Transactional
    @Override
    public int deleteByNumContrat(int numContrat) {
        return contratDao.deleteByNumContrat(numContrat);
    }



    @Override
    public int update(Contrat contrat) {
        Contrat existingContrat = findByNumContrat(contrat.getNumContrat());

        if (existingContrat == null) {
            return -1;
        }

        try {

            if (contrat.getLocation() == null) {
                return -2;
            }
            if (contrat.getLocation().getRef() == null) {
                return -3;
            }
            if(locationService.findByRef(contrat.getLocation().getRef())==null){
                return -4;
            }
            if (contrat.getLocation() != null) {
                Location location = locationService.findByRef(contrat.getLocation().getRef());
                contrat.setLocation(location);
            }
            existingContrat.setDateSignature(contrat.getDateSignature());
            existingContrat.setDureeRetard(contrat.getDureeRetard());
            existingContrat.setModelePaiement(contrat.getModelePaiement());
            existingContrat.setPrixHT(contrat.getPrixHT());
            existingContrat.setTva(contrat.getTva());
            existingContrat.setRest(contrat.getRest());
            contratDao.save(existingContrat);

            return 1;

        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de la contrat : " + e.getMessage());
            e.printStackTrace();
            return -6;
        }
    }




//    @Override
//    public int update(ContratDto contratDto) {
//        System.out.println(contratDto.getNumContrat());
//        System.out.println(contratDto.getDateSignature());
//        System.out.println(contratDto.getPrixHT());
//        System.out.println(contratDto.getTva());
//        if(contratDto == null){
//            return -1 ;
//        }
//        int numContra = contratDto.getNumContrat();
//        if(numContra == 0){
//            return -2 ;
//        }
//        Contrat contrat = contratDao.findByNumContrat(numContra);
//        if(contrat == null){
//            return -3 ;
//        }
//        Location location = locationDao.findByRef(contrat.getLocation().getRef());
//        if (location == null) {
//            System.out.println("location est null");
//            return -4;
//        }
//        if (locationDao.findByRef(location.getRef()) == null) {
//            System.out.println("Cette location n'existe pas");
//            return -5;
//        }
//
//        contrat.setLocation(location);
//        BeanUtils.copyProperties(contratDto , contrat);
//        contratDao.save(contrat);
//        return 1;
//    }


}


