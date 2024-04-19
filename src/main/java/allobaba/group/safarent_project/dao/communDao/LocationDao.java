package allobaba.group.safarent_project.dao.communDao;


import allobaba.group.safarent_project.bean.communBean.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends JpaRepository<Location,Long > {
    Location findByRef(String ref);
    Location findByIdLocation(Long id);

    int deleteByRef(String ref);
}
