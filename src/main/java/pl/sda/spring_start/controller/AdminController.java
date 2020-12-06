package pl.sda.spring_start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.spring_start.model.User;
import pl.sda.spring_start.service.UserService;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getAdminPanel(Model model) {
        List<User> users = userService.getAllUsersOrderByRegistrationDateTimeDesc();
        model.addAttribute("users", users);
        return "tables";
    }
    @GetMapping("/users/addAdmin&{userId}")
    public String addAdmin(@PathVariable("userId") int userId){
        return null;
    }
    @GetMapping("/users/changeStatus&{userId}")
    public String changeUserStatus(@PathVariable("userId") int userId){
        return null;
    }
}
