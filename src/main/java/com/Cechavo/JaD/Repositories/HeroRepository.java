package com.Cechavo.JaD.Repositories;

import com.Cechavo.JaD.Entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

    @Query("SELECT h FROM Hero h WHERE h.userId = :userId")
    public List<Hero> findHeroByUserId (@Param("userId") int userId);
}
