package com.lirysBoo.characters.mobs;
import com.lirysBoo.characters.Character;

import java.util.ArrayList;

public class IntermediateMobs extends Character {

    public IntermediateMobs(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense) {
        super(name, baseMaxHP, HP, baseAttack, baseDefense);
        intermediateMobsList.add(this);
    }

    public static final ArrayList<Character> intermediateMobsList = new ArrayList<>();

    @SuppressWarnings("unused")
    public static void generateMobs(){
        IntermediateMobs zombie = new IntermediateMobs(
                "Zombie",
                35,
                35,
                10,
                15);
    }
}