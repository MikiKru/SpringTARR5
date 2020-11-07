package pl.sda.spring_start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring_start.model.User;
import pl.sda.spring_start.repository.UserRepository;

@Service            // servis - implementuje logikę aplikacji
public class ServiceController {
    @Autowired      // wstrzykiwanie zależności
    UserRepository userRepository;

    public void registerUser(User user){
        userRepository.save(user);          // INSERT INTO user valsues (?,?,?,?)
    }

}
