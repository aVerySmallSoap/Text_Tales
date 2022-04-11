package com.LirysBoo.Characters;
import com.LirysBoo.Logic.GameLogic;

import java.util.concurrent.ThreadLocalRandom;

public class Character {
    private String name;
    private int HP, baseAttack,baseDefense;
    //TODO: leveling system(exp, stats), shop(gold, items)

    //Allows us to create a blank Character object
    public Character() {
    }

    public Character(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense){
        this.name = name;
        this.HP = baseMaxHP;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    // Getters & Setters
    public String getName(){return this.name;}
    public int getBaseAttack(){return this.baseAttack;}
    public int getBaseDefense(){return this.baseDefense;}
    public int getHP(){return this.HP;}
    public int Attack(){return Damage();}

    //Common Methods
    /**
     * Calculates the raw attack damage.
     * @return Raw attack damage
     */
    public int attackCalculation(){
        float minDamage = (baseAttack * 1.25f) / baseAttack; // Base player damage is 5; 3.75 min(75%) : 5 max(100%)
        return ThreadLocalRandom.current().nextInt((int)minDamage, baseAttack);
    }

    /**
     * Defensive properties of type Character.
     * Percentage based reduction is used for a more balanced damage output.
     */
    public float Defense(){
        return baseDefense / 100f; //% damage reduction; where 1 = 0.01%
    }

    /**
     * Calculates the total damage dealt with defense reductions
     * @return Reduced Damaged
     */
    public int Damage() {
        float defense = Defense(); // Get defense value
        int attack = attackCalculation();  // Get attack value
        float damageReduction = attack * defense;
        return (int) (attackCalculation() - damageReduction);
    }

    public void printStats(Character entity){
        GameLogic.header(entity.getName());
        System.out.println("HP: " + entity.getHP());
        System.out.println("Attack: " + entity.getBaseAttack());
        System.out.println("Defense: " + entity.getBaseDefense());
    }



    //TODO: skills
}

