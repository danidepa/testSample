package ve.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ve.com.model.User;
import ve.com.repository.UsersRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 893414 on 4/30/2015.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UsersRepository userRepository;

    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    public User create(User user)
    {
        return userRepository.save(user);
    }

    public User findUserById(Long id)
    {
        return userRepository.findOne(id);
    }

    public User update(User user)
    {
        return userRepository.save(user);
    }

    public void deleteUser(Long id)
    {
        userRepository.delete(id);
    }

    public User findUserByEmail(String email)
    {
        return userRepository.findUserByEmail(email);
    }

}
