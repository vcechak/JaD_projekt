package com.Cechavo.JaD.Services;

import java.util.List;
import java.util.Optional;

import com.Cechavo.JaD.Entities.Hero;
import com.Cechavo.JaD.Repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroRepository heroRepo;

    @Autowired
    private UserService userService;

    //vyhledání všech hrdinů
    @Override
    public List<Hero> getAllHeroes(){
        return heroRepo.findAll();
    }

    //Vyhledání hrdinů podle ID
    @Override
    public List<Hero> getHeroesByUserId(int thisId) {
        return heroRepo.findHeroByUserId(thisId);
    }


    //Uložení nového hrdiny
    @Override
    public void saveHero(Hero hero) {
        this.heroRepo.save(hero);
    }

    //vyhledání hrdiny dle heroID
    @Override
    public Hero getHeroById(long id) {
       Optional<Hero> optional = heroRepo.findById(id);
       Hero hero = null;
       if(optional.isPresent()) {
           hero = optional.get();
       } else {

       }
       return hero;
    }

    //Smazání hrdiny dle ID
    public void deleteHeroById(long id) {
        this.heroRepo.deleteById(id);
    }
}
