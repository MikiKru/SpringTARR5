package pl.sda.spring_start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring_start.model.User;
import pl.sda.spring_start.repository.UserRepository;

import java.util.Optional;

@Service            // servis - implementuje logikę aplikacji
public class UserService {
    @Autowired      // wstrzykiwanie zależności
    UserRepository userRepository;

    public void registerUser(User user){
        userRepository.save(user);          // INSERT INTO user values (?,?,?,?)
    }
    public void activateUser(int userId){   // UPDATE user SET status = 1 WHERE user_id = ?;
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setStatus(true);
            userRepository.save(user);      // save gdy jest wywoływana na istniejącym w db obiekcie to działa jak update
        }
    }

}
