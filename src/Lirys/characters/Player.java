package Lirys.characters;

import Lirys.logic.Helper;
import Lirys.logic.items.Consumables;
import Lirys.logic.items.Items;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that extends {@link Character}. <br>
 * <p>
 *     {@code Player} is a class that stores the information of the player.
 */
public class Player extends Character {

    static Items items;

    protected static final Map<Integer, Items> PLAYER_INVENTORY = new HashMap<>(); //Slot, Item

    //Getters & Setters
    public void addItemToInventory(){
        for (int i = 0; i < PLAYER_INVENTORY.size(); i++) {
            if (PLAYER_INVENTORY.get(i) == null){
                Items a = items.getItem("Lirys:Healing_Potion");
                PLAYER_INVENTORY.put(a.getITEM_NUMBER_TAG(), a);
            }else{
                i++;
            }
        }
    }

    public void getItemsInventory(){
        for (int metaID: PLAYER_INVENTORY.keySet()){
            if (metaID == 0){
                Items item = PLAYER_INVENTORY.get(metaID);
                System.out.println(item.getItemName());
                System.out.println("Amount: " + item.getItemCount());
                Helper.Separator(5);
            }
        }
    }

    public static void removeItemFromInventory(){

    }

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
