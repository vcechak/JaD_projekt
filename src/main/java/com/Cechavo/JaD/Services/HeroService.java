package com.Cechavo.JaD.Services;

import com.Cechavo.JaD.Entities.Hero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HeroService {

    List<Hero> getAllHeroes();
    //Vyhledání hrdinů podle ID
    public List<Hero> getHeroesByUserId(int id);

    //Vyhledání hrdinů podle ID


    void saveHero(Hero hero);
    Hero getHeroById(long id);
    void deleteHeroById(long id);
}
