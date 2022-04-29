package com.LirysBoo.Characters.mobs;
import com.LirysBoo.Characters.Character;

import java.util.ArrayList;

public class IntermediateMobs extends Character {

    public IntermediateMobs(){}

    public IntermediateMobs(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense) {
        super(name, baseMaxHP, HP, baseAttack, baseDefense);
        intermediateMobsList.add(this);
    }

    public static ArrayList<Character> intermediateMobsList = new ArrayList<>();

    @SuppressWarnings("unused")
    public static void generateMobs(){
        IntermediateMobs zombie = new IntermediateMobs(
                "Zombie",
                35,
                35,
                15,
                25);
        IntermediateMobs werewolf = new IntermediateMobs(
        		"Werewolf",
        		35,
        		35,
        		20,
        		20);
        IntermediateMobs skeleton = new IntermediateMobs(
        		"Skeleton",
        		30,
        		40,
        		20,
        		20);
    }
}
