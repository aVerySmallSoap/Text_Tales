package com.LirysBoo.Characters;
import com.LirysBoo.Logic.GameLogic;

public class Character {
    private String name;
    public int HP, baseMaxHP;
    private int baseAttack,baseDefense, attack;
    //TODO: leveling system(exp, stats), shop(gold, items)

    //Allows us to create a blank Character object
    public Character() {
    }

    public Character(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense){
        this.name = name;
        this.baseMaxHP = baseMaxHP;
        this.HP = baseMaxHP;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    // Getters & Setters
    public String getName(){return this.name;}
    public int getBaseAttack(){return this.baseAttack;}
    public int getBaseDefense(){return this.baseDefense;}
    public int getBaseMaxHP(){return this.baseMaxHP;}
    public int getHP(){return this.HP;}
    public int getAttack(){return attack;}

    public void setCurrentHP(int damageDealt){
        if(this.HP <= 0 && damageDealt > this.HP){
            this.HP = 0;
        }else{
            this.HP = HP - damageDealt;
        }
    } // For damage being dealt
    public void setHP(int HP){this.HP = HP;}

    //Common Methods

    /**
     * Defensive properties of type Character.
     * Percentage based reduction is used for a more balanced damage output.
     */
    public float Defense(){
        return this.baseDefense / 100f; //% damage reduction; where 1 = 0.01%
    }

    /**
     * Calculates the total damage dealt with defense reductions
     * @return Attack (after damage reductions)
     */
    public int Attack() {
        float minDamage = this.baseAttack * 0.75f; // Base player damage is 5; 3.75 min(75%) : 5 max(100%)
        double variedDamage = minDamage + (Math.random() * this.baseAttack);
        float defense = Defense(); //TODO: Fix on how to get the enemies defense value
        double defenseDamageReduction = variedDamage * defense;
        attack = (int) (variedDamage - defenseDamageReduction);
        return attack;
    }

    /**
     * Generates the stats of an entity
     *
     */
    public void printStats(Character entity){
        GameLogic.header(entity.getName());
        System.out.println("HP: " + entity.getHP());
        System.out.println("Attack: " + entity.getBaseAttack());
        System.out.println("Defense: " + entity.getBaseDefense());
    }

    //TODO: Multiple Properties
    public void heal(){
        this.HP = getHP() + 25;
        if(this.HP > 100){
            this.HP = 100;
        }
    }

    //TODO: skills
}

