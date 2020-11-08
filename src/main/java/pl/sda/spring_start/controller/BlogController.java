package pl.sda.spring_start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.spring_start.service.PostService;
import pl.sda.spring_start.service.UserService;

@Controller     // klasa mapująca url na wywołanie metody i zwracająca widok html
public class BlogController {
    private UserService userService;
    private PostService postService;
    @Autowired
    public BlogController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }
    @GetMapping("/")        // na adresie localhost:8080/
    public String home(Model model){   // wywołaj metodę home()
        // dodaje atrybut do obiektu model, który może być przekazany do widoku
        // model.addAttribute(nazwaAtrybutu, wartość);
        model.addAttribute("posts", postService.getAllPosts());
        return "index";     // zwracającą nazwę dokumentu html który ma być wyświetlany
    }
}
