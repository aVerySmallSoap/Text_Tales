package com.LirysBoo.Characters.mobs;
import com.LirysBoo.Characters.Character;
import java.util.ArrayList;
import java.util.List;

public class BasicMobs extends Character{

    //Allows us to create a blank BasicMobs object
    public BasicMobs(){}

    public BasicMobs(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense) {
        super(name, baseMaxHP, HP, baseAttack, baseDefense);
        basicMobsList.add(this);
    }

    public static List<BasicMobs> basicMobsList = new ArrayList<>();
    //Special Methods
    //TODO: Special Methods for basic mobs.
    //TODO: New Mob class structure and mob generation.
    public void generateBasicMobs(){
        BasicMobs Goblin = new BasicMobs("Goblin",25, 25,5,5);
        BasicMobs Troll = new BasicMobs("Troll",30, 30,7,10);
        BasicMobs goblinWizard = new BasicMobs("Goblin Wizard",15, 15,12,0);
    }

}

