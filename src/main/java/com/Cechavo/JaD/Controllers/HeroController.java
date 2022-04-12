package com.Cechavo.JaD.Controllers;

import com.Cechavo.JaD.Entities.Hero;
import com.Cechavo.JaD.Repositories.HeroRepository;
import com.Cechavo.JaD.Services.HeroService;
import com.Cechavo.JaD.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class HeroController {
    @Autowired
    private HeroService heroService;

    @Autowired
    private HeroRepository heroRepo;

    @Autowired
    private UserService userService;

    //Metoda na zobrazení listu hrdinů
    @GetMapping("/heroes")
    public String viewHeroes(Model model) {
        model.addAttribute("listHeroes", heroService.getAllHeroes());
        return "herolist";
    }

    //Vytvoření hrdiny
    @GetMapping("/newHeroForm")
    public String showNewHeroForm(Model model) {
        Hero hero = new Hero();
        hero.setUserId(userService.getPrincipalId());
        model.addAttribute("hero", hero);
        return "new_hero";
    }

    //Uložení hrdiny
    @PostMapping("/saveHero")
    public String saveHero(@ModelAttribute("hero") Hero hero) {
        //uložení do databáze
        heroService.saveHero(hero);
        long id = hero.getHeroId();

        return "redirect:/showHero/" + id;
    }

    //Upravení hrdiny
    @GetMapping("/updateHeroForm/{id}")
    public String updateHeroForm(@PathVariable(value="id") long id, Model model) {
        //získat hrdinu ze service
        Hero hero = heroService.getHeroById(id);
        //nastavit hrdinu jako model k předvyplnění form
        model.addAttribute("hero", hero);
        return "update_hero";
    }

    //Zobrazení detailu hrdiny
    @GetMapping("/showHero/{id}")
    public String showHero(@PathVariable(value="id") long id, Model model) {
        //získat hrdinu ze service
        Hero hero = heroService.getHeroById(id);
        //nastavit hrdinu jako model k předvyplnění forms
        model.addAttribute("hero", hero);
        return "show_hero";
    }


    //Smazání hrdiny
    @GetMapping("/deleteHero/{id}")
    public String deleteHeroById(@PathVariable (value="id") long id, Model model) {
        this.heroService.deleteHeroById(id);
        return "redirect:/home";
    }
}

