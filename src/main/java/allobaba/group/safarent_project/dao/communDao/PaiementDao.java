package allobaba.group.safarent_project.dao.communDao;

import allobaba.group.safarent_project.bean.communBean.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<Paiement,Long > {
    Paiement findByRef(String ref);
    int deleteByRef(String ref);
}
