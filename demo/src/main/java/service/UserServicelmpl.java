package service;


import com.example.demo.dao.UserDAO;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll(){
        return (List<User>) userDAO.findAll();
    }
    @Override
    public User findById(Long id){
        return userDAO.findById(id).orElse(null);
    }
    @Override
    public void createUser(User user){
        userDAO.save(user);
    }
    @Override
    public void modifyUser(Long id, User user){
        if(userDAO.existsById(id)){
            user.setId(id);
            userDAO.save(user);
        }
    }
    @Override
    public void deleteUser(Long id) {
        if(userDAO.existsById(id)){
            userDAO.deleteById(id);
        }
    }
}
