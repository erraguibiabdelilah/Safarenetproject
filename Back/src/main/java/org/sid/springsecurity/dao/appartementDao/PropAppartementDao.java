package org.sid.springsecurity.dao.appartementDao;

import org.sid.springsecurity.bean.appartementBean.PropAppartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropAppartementDao extends JpaRepository<PropAppartement,Long> {
    PropAppartement findByCin(String cin);
    int deleteByCin(String cin);
}
