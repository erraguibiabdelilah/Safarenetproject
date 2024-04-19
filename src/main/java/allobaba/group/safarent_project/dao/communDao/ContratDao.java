package allobaba.group.safarent_project.dao.communDao;

import allobaba.group.safarent_project.bean.communBean.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratDao extends JpaRepository<Contrat ,Long > {
    Contrat findByNumContrat(int numContrat);
    int deleteByNumContrat(int numContrat); }
