package ve.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ve.com.model.Role;

import java.io.Serializable;

/**
 * Created by 893414 on 4/30/2015.
 */
public interface RoleRepository extends JpaRepository<Role,Serializable>{
}
