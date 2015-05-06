package ve.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ve.com.model.User;

import java.io.Serializable;

/**
 * Created by 893414 on 4/22/2015.
 */
public interface UsersRepository extends JpaRepository<User,Serializable> {

    User findUserByEmail(String email);
}
