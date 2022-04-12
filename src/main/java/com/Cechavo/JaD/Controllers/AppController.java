package com.Cechavo.JaD.Controllers;

import com.Cechavo.JaD.Entities.Hero;
import com.Cechavo.JaD.Entities.User;
import com.Cechavo.JaD.Repositories.UserRepository;
import com.Cechavo.JaD.Services.HeroService;
import com.Cechavo.JaD.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
public class AppController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private UserService userService;

    //Mapping Index
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    //connected into app
    @GetMapping("/home")
    public String home(Model model) {
            model.addAttribute("listHeroes", heroService.getHeroesByUserId(userService.getPrincipalId()));
        return "home";
    }

    //Mapping login
    @GetMapping("/login")
    public String login() {
        return "login";
    }






}

