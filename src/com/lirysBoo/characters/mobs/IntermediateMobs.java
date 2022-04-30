package com.lirysBoo.characters.mobs;

import com.lirysBoo.characters.Character;

import java.util.ArrayList;

/**
 * A class that extends {@link Character}. <br>
 * <p>
 *     {@code IntermediateMobs} is a class that stores the information of intermediate mobs.
 *     It is also used to create intermediate mobs which the player may encounter.
 */
public class IntermediateMobs extends Character {

    //Constructor
    public IntermediateMobs(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense) {
        super(name, baseMaxHP, HP, baseAttack, baseDefense);
        intermediateMobsList.add(this);
    }

    //An array list that holds every instantiation of IntermediateMobs
    public static final ArrayList<Character> intermediateMobsList = new ArrayList<>();

    /**
     * Generates intermediate mobs for the player to fight.<br>
     * <p>
     *     This method allows the programme to generate or instantiate the <i>hard coded</i> {@link IntermediateMobs}
     * </p>
     */
    @SuppressWarnings("unused")
    public static void generateMobs(){
        IntermediateMobs zombie = new IntermediateMobs(
                "Zombie",
                35,
                35,
                10,
                15);
    }
    IntermediateMobs Werewolf = new IntermediateMobs(
            "Werewolf",
            35,
            35,
            20,
            20);
    IntermediateMobs Skeleton = new IntermediateMobs(
            "Skeleton",
            30,
            40,
            20,
            20);
}
