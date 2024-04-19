package allobaba.group.safarent_project.dao.appartementDao;


import allobaba.group.safarent_project.bean.appartementBean.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppartementDao extends JpaRepository<Appartement,Long> {
   Appartement findByCode(String code);
   int deleteByCode(String code);

   List<Appartement> findByCategoriesAppartementLibelle(String libelle);

   List<Appartement> findByPropAppartementCin(String cin);

}
