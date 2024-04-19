package allobaba.group.safarent_project.dao.communDao;

import allobaba.group.safarent_project.bean.communBean.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDao extends JpaRepository<Facture , Long> {
    Facture findByRef(String ref);
    int deleteByRef(String ref);
}
