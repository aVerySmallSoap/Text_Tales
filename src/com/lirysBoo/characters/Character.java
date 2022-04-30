package com.lirysBoo.characters;

import com.lirysBoo.logic.Helper;

import java.util.concurrent.ThreadLocalRandom;

import static com.lirysBoo.logic.GameLogic.mob;
import static com.lirysBoo.logic.GameLogic.player;


/**
 * An abstract class that allows the creation of a {@code Character}
 * <br>
 *<p>
 *     This class allows the construction of objects with type {@code Character} with the constructor {@link #Character(String, int, int, int, int)}.<br>
 *     This class is created as an {@code abstract} class to allow other classes to inherit or extend this class.
 */
public abstract class Character {

    //Holds the name of a character
    private final String name;

    /*
    * Holds the value of three things:
    * Maximum hit-points of a character
    * BASE attack damage of a character
    * BASE defense of a character*/
    private final int baseMaxHP, baseAttack,baseDefense;

    /*
    * The HP variable functions as a temporary holder of baseMaxHP which makes it mailable
    * The attack variable is used as a mediator to hold the calculation of attackCalculation*/
    private int HP, attack;
    //TODO: leveling system(exp, stats), shop(gold, items)

    /**
     * Constructor method that allows the instantiation of a {@code Character} object.
     * @param name the name of this entity
     * @param baseMaxHP the max health points of this entity
     * @param HP the <i>current</i> health points of this entity
     * @param baseAttack the <i>base</i> attack damage of this entity
     * @param baseDefense the <i>base</i> defense/armour of this entity
     */
    public Character(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense){
        this.name = name;
        this.HP = baseMaxHP;
        this.baseMaxHP = HP; // redundant
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    //Getters and Setters methods.
    /**
     *
     * @return {@link #name}
     */
    public String getName(){return this.name;}

    /**
     * @return {@link #baseAttack}
     */
    public int getBaseAttack(){return this.baseAttack;}

    /**
     * @return {@link #attackCalculation()}
     */
    public int getAttack(){return attackCalculation();}

    /**
     * @return {@link #baseDefense}
     */
    public int getBaseDefense(){return this.baseDefense;}

    /**
     * @return {@link #baseMaxHP}
     */
    public int getBaseMaxHP(){return this.baseMaxHP;}

    /**
     * @return {@link #HP}
     */
    public int getHP(){return this.HP;}

    /**
     * @return {@link #Defense()}
     */
    public float getDefense(){return this.Defense();}

    /**
     * getter method that retrieves {@link #printStats(Character)}
     */
    public void getStats(){printStats(this);}

    /**
     * setter method that sets the {@link #HP} of {@code this} entity
     * @param HP the amount to be set
     */
    public void setHP(int HP){this.HP = HP;}

    /**
     * setter method that deals the damage to the current {@link #HP} of {@code this} entity
     * @param damageDealt the amount of damage to be dealt
     */
    public void dealDamageToCurrentHP(int damageDealt){
            this.HP = HP - damageDealt;
    }

    //Common Methods
    /**
     * Calculates the defense of a {@link Character} in <i>percentage(%)</i>.<br>
     */
    private float Defense(){
        return this.baseDefense / 100f; //% damage reduction; where 1 = 0.01%
    }

    /**
     * Calculates the total damage dealt to a {@code Character} with {@code defense} reductions.<br>
     * @return {@link #attack}
     */
    private int attackCalculation() {
        float minDamage = this.baseAttack * 0.75f; // Base player damage is 5; 3.75 min(75%) : 5 max(100%)
        double variedDamage = ThreadLocalRandom.current().nextDouble(minDamage, this.baseAttack+1);
        if (this == player){
            float defense = mob.getDefense();
            double defenseDamageReduction = variedDamage * defense;
            attack = (int) (variedDamage - defenseDamageReduction);
        }else if (this == mob){
            float defense = player.getDefense();
            double defenseDamageReduction = variedDamage * defense;
            attack = (int) (variedDamage - defenseDamageReduction);
        }
        return attack;
    }

    //Prints the stats of an entity
    private void printStats(Character entity){
        Helper.Header(entity.getName());
        System.out.println("HP: " + entity.getHP() + "/" + entity.getBaseMaxHP());
        System.out.println("Attack: " + entity.getBaseAttack());
        System.out.println("Defense: " + entity.getBaseDefense());
    }

    // Healing for all Character types
    public void heal(){
        this.HP = getHP() + 25;
        if(this.HP > 100){
            this.HP = 100;
        }
    }

    // Critical chance for all Character types
    // public void crit(){}

    //TODO: skills
    /*
    in the characters class, every instance has access to these common skills.
    These skills may include, burst, critical_swing, etc.
    */
}

