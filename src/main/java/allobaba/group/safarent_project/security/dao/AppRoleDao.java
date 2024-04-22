package allobaba.group.safarent_project.security.dao;

import org.sid.springsecurity.security.bean.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleDao extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
