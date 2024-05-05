package service;


import com.example.demo.dao.MovementDAO;
import com.example.demo.entities.Movement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServiceImpl implements MovementService {
    @Autowired
    private MovementDAO movementDAO;

    @Override
    public List<Movement> findAll(){
        return (List<Movement>) movementDAO.findAll();
    }
    @Override
    public Movement findById(Long id){
        return movementDAO.findById(id).orElse(null);
    }
    @Override
    public void createMovement(Movement movement){
        movementDAO.save(movement);
    }
    @Override
    public void modifyMovement(Long id, Movement movement){
        if(movementDAO.existsById(id)){
            movement.setId(id);
            movementDAO.save(movement);
        }
    }
    @Override
    public void deleteMovement(Long id) {
        if(movementDAO.existsById(id)){
            movementDAO.deleteById(id);
        }
    }
}
