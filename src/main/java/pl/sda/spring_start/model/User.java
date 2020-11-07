package pl.sda.spring_start.model;
// klasa determinująca strukturę danych w projekcie

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity         // determinuje mapowanie klasy na tabelkę DB
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;             // auto inkrementowany klucz głównym tabeli
    private String email;
    private String password;
    private LocalDateTime registrationDateTime;
    private boolean status;

}
