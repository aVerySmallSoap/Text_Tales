package com.lirysBoo.characters.mobs;

import com.lirysBoo.characters.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that extends {@link Character}. <br>
 * <p>
 *     {@code BasicMobs} is a class that stores the information of basic mobs.
 *     It is also used to create basic mobs which the player may encounter.
 */
public class BasicMobs extends Character{

    //Constructor
    public BasicMobs(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense) {
        super(name, baseMaxHP, HP, baseAttack, baseDefense);
        basicMobsList.add(this);
    }

    //An array list that holds every instantiation of BasicMobs
    public static final List<Character> basicMobsList = new ArrayList<>();

    //Special Methods
    //TODO: Special Methods for basic mobs.
    //TODO: New Mob class structure and mob generation.


    /**
     * Generates basics mobs for the player to fight.<br>
     * <p>
     *     This method allows the programme to generate or instantiate the <i>hard coded</i> {@link BasicMobs}
     * </p>
     */
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


