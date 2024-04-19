package allobaba.group.safarent_project.dao.appartementDao;


import allobaba.group.safarent_project.bean.appartementBean.CategoriesAppartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesAppartementDao extends JpaRepository<CategoriesAppartement,Long> {
    CategoriesAppartement findByLibelle(String libelle);
    int deleteByLibelle(String libelle);
}
