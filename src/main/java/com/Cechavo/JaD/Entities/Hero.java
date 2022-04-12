
package com.Cechavo.JaD.Entities;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "hero")
public class Hero {

        @Id
        @Column (name="hero_id" )
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long heroId;
        //Definition of Heroes MySQL table
        @Column(name ="user_id", nullable= false)
        private int userId;
        @Column(nullable = false, length = 55)
        private String heroName;
        @Column(nullable = false, length = 55)
        private String heroClass;
        @Column(nullable= false)
        private Integer strength;
        @Column(nullable= false)
        private Integer agility;
        @Column(nullable= false)
        private Integer endurance;
        @Column(nullable= false)
        private Integer intelligence;
        @Column(nullable= false)
        private Integer wisdom;
        @Column(nullable= false)
        private Integer charisma;
        @Column(nullable=true, length=500)
        private String weapons;


        //Getters/setters
        public long getHeroId() {
            return heroId;
        }

        public void setHeroId(long heroId) {
            this.heroId = heroId;
        }

        public Integer getUserId() {
                return userId;
            }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getHeroName() {
            return heroName;
        }

        public void setHeroName(String heroName) {
            this.heroName = heroName;
        }

        public Integer getStrength() {
            return strength;
        }

        public void setStrength(Integer strength) {
            this.strength = strength;
        }

        public Integer getAgility() {
            return agility;
        }

        public void setAgility(Integer agility) {
            this.agility = agility;
        }

        public Integer getEndurance() {
            return endurance;
        }

        public void setEndurance(Integer endurance) {
            this.endurance = endurance;
        }

        public Integer getIntelligence() {
            return intelligence;
        }

        public void setIntelligence(Integer intelligence) {
            this.intelligence = intelligence;
        }

        public Integer getWisdom() {
            return wisdom;
        }

        public void setWisdom(Integer wisdom) {
            this.wisdom = wisdom;
        }

        public Integer getCharisma() {
            return charisma;
        }

        public void setCharisma(Integer charisma) {
            this.charisma = charisma;
        }

        public String getWeapons() {
            return weapons;
        }

        public void setWeapons(String weapons) {
            this.weapons = weapons;
        }

        public String getHeroClass() {
            return heroClass;
        }

        public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }
}
