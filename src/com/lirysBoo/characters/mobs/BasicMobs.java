package com.lirysBoo.characters.mobs;
import com.lirysBoo.characters.Character;
import java.util.ArrayList;
import java.util.List;

public class BasicMobs extends Character{

    public BasicMobs(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense) {
        super(name, baseMaxHP, HP, baseAttack, baseDefense);
        basicMobsList.add(this);
    }

    public static final List<Character> basicMobsList = new ArrayList<>();

    //Special Methods
    //TODO: Special Methods for basic mobs.
    //TODO: New Mob class structure and mob generation.
    @SuppressWarnings("unused")
    public static void generateMobs() {
        BasicMobs goblinGrunt = new BasicMobs(
                "Goblin Grunt",
                10,
                10,
                2,
                1
        );

        BasicMobs Goblin = new BasicMobs(
                "Goblin",
                25,
                25,
                5,
                5);

        BasicMobs goblinWizard = new BasicMobs(
                "Goblin Wizard",
                15,
                15,
                12,
                0);


        BasicMobs goblinWarrior = new BasicMobs(
                "Goblin Warrior",
                30,
                30,
                10,
                10
        );

        BasicMobs goblinMenace = new BasicMobs(
                "Goblin Menace",
                18,
                18,
                5,
                30
        );
    }
}


