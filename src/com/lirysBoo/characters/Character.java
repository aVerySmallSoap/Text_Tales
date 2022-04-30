package com.lirysBoo.characters;

import com.lirysBoo.logic.Helper;

import java.util.concurrent.ThreadLocalRandom;

import static com.lirysBoo.logic.GameLogic.mob;
import static com.lirysBoo.logic.GameLogic.player;

public abstract class Character {
    private final String name;

    private final int baseMaxHP, baseAttack,baseDefense;

    private int HP, attack;
    //TODO: leveling system(exp, stats), shop(gold, items)

    //Allows us to create a blank Character object

    public Character(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense){
        this.name = name;
        this.HP = baseMaxHP;
        this.baseMaxHP = HP; // redundant
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    /**
     * Getters and Setters methods. <br></br>
     * Every single get and set methods are written below.
     */

    public String getName(){return this.name;}

    public int getBaseAttack(){return this.baseAttack;}

    public int getAttack(){return attackCalculation();}

    public int getBaseDefense(){return this.baseDefense;}

    public int getBaseMaxHP(){return this.baseMaxHP;}

    public int getHP(){return this.HP;}

    public float getDefense(){return this.Defense();}

    public void getStats(){printStats(this);}

    public void setHP(int HP){this.HP = HP;}

    public void setCurrentHP(int damageDealt){
        if(this.HP <= 0){
            this.HP = 0;
        }else{
            this.HP = HP - damageDealt;
        }
    }

    //Common Methods

    /**
     * Defensive properties of type Character.
     * Percentage based reduction is used for a more balanced damage output.
     */
    private float Defense(){
        return this.baseDefense / 100f; //% damage reduction; where 1 = 0.01%
    }

    /**
     * Calculates the total damage dealt with defense reductions
     * @return getAttack
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

    /**
     * Prints the stats of an entity
     *
     */
    private void printStats(Character entity){
        Helper.Header(entity.getName());
        System.out.println("HP: " + entity.getHP() + "/" + entity.getBaseMaxHP());
        System.out.println("Attack: " + entity.getBaseAttack());
        System.out.println("Defense: " + entity.getBaseDefense());
    }

    //TODO: Multiple Properties.
    /*
    In the characters class, every instance has access to these common properties.
    These properties may include, healing, critical hits, etc.
    */

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

