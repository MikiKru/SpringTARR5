package pl.sda.spring_start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller     // klasa mapująca url na wywołanie metody i zwracająca widok html
public class BlogController {
    @GetMapping("/")        // na adresie localhost:8080/
    public String home(){   // wywołaj metodę home()
        return "index";     // zwracającą nazwę dokumentu html który ma być wyświetlany
    }
}
