package pl.sda.spring_start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.spring_start.model.User;

import java.util.Optional;

@Repository         // repozytorium - interfejs implementujący zapytania SQL
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findFirstByEmail(String email);      // SELECT * FROM user WHERE email = ?;
}
