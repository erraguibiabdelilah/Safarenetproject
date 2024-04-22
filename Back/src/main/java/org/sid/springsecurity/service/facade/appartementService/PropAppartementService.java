package org.sid.springsecurity.service.facade.appartementService;


import org.sid.springsecurity.bean.appartementBean.PropAppartement;
import org.sid.springsecurity.ws.dto.appartementDto.PropAppartemenetDto;

import java.util.List;

public interface PropAppartementService {
    int save(PropAppartement propAppartement);
    List<PropAppartement> findAll();
    int update(PropAppartemenetDto propAppartemenetDto);
    PropAppartement findByCin(String cin);
    int deleteByCin(String cin);


}
