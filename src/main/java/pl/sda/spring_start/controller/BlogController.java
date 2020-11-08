package pl.sda.spring_start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller     // klasa mapująca url na wywołanie metody i zwracająca widok html
public class BlogController {
    @GetMapping("/")        // na adresie localhost:8080/
    public String home(Model model){   // wywołaj metodę home()
        // dodaje atrybut do obiektu model, który może być przekazany do widoku
        // model.addAttribute(nazwaAtrybutu, wartość);
        model.addAttribute("title", "Michael's blog");
        model.addAttribute("subtitle", "The best blog in the World");
        return "index";     // zwracającą nazwę dokumentu html który ma być wyświetlany
    }
}
