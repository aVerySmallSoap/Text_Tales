package Lirys.characters.mobs;

import Lirys.characters.Character;
import static Lirys.characters.mobs.MobCollection.MOB_COLLECTION;

/**
 * A class that extends {@link Character}. <br>
 * <p>
 *     {@code BasicMobs} is a class that stores the information of basic mobs.
 *     It is also used to create basic mobs which the player may encounter.
 */
public class Mobs extends Character{
    //Constructor
    public Mobs(String name, int baseMaxHP, int HP, int baseAttack, int baseDefense) {
        super(name, baseMaxHP, HP, baseAttack, baseDefense);
        MOB_COLLECTION.Add(this);
    }
    //Special Methods
    //TODO: Special Methods for basic mobs.
    //TODO: New Mob class structure and mob generation.
    /**
     * Generates basics mobs for the player to fight.<br>
     * <p>
     *     This method allows the programme to generate or instantiate the <i>hard coded</i> {@link Mobs}
     * </p>
     */
    @SuppressWarnings("unused")
    public static void generateMobs() {
        Mobs goblinGrunt = new Mobs(
                "Goblin Grunt",
                10,
                10,
                2,
                1
        );

        Mobs Goblin = new Mobs(
                "Goblin",
                25,
                25,
                5,
                5);

        Mobs goblinWizard = new Mobs(
                "Goblin Wizard",
                15,
                15,
                12,
                0);

        Mobs goblinWarrior = new Mobs(
                "Goblin Warrior",
                30,
                30,
                10,
                10
        );

        Mobs goblinMenace = new Mobs(
                "Goblin Menace",
                18,
                18,
                5,
                30
        );

        Mobs zombie = new Mobs(
                "Zombie",
                35,
                35,
                10,
                15);

        Mobs Werewolf = new Mobs(
                "Werewolf",
                35,
                35,
                20,
                20);

        Mobs Skeleton = new Mobs(
                "Skeleton",
                30,
                40,
                20,
                20);
    }
}