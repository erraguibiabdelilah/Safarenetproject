package allobaba.group.safarent_project.security.dao;

import org.sid.springsecurity.security.bean.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserDao extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
