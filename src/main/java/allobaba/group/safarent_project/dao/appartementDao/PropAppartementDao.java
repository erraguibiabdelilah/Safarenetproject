package allobaba.group.safarent_project.dao.appartementDao;

import allobaba.group.safarent_project.bean.appartementBean.PropAppartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropAppartementDao extends JpaRepository<PropAppartement,Long> {
    PropAppartement findByCin(String cin);
    int deleteByCin(String cin);
}
