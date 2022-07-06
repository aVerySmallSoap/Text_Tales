package Lirys.characters;

/**
 * A class that extends {@link Character}. <br>
 * <p>
 *     {@code Player} is a class that stores the information of the player.
 */
public class Player extends Character {

    //Constructor
    public Player(String name){
        super(
                name,
                100,
                100,
                7,
                10);
    }

    //TODO: Special properties
    //A variable that checks if the player has used heal.
    public boolean usedHeal = false;

    //TODO: Player exclusive skills
}
