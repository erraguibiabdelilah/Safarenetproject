package org.sid.springsecurity.service.facade.communService;


import org.sid.springsecurity.bean.communBean.Location;

import java.util.List;

public interface LocationService {
    int save(Location location);
    List<Location> findAll();

    Location findByRef(String ref);

    int deleteByRef(String ref);

    int update(Location voiture);
}
