package Lirys.logic.items;

import static Lirys.logic.items.Items.ITEMS_COLLECTION;

public class Consumables extends Items{

    public Consumables(){}

    public Consumables(String itemName, String itemTag, int count){
        super(itemName, itemTag, count);
        ITEMS_COLLECTION.put(this.getITEM_TAG(), this);
    }

    @SuppressWarnings("unused")
    public void init(){
        Consumables healthPot = new Consumables(
                "Healing Potion",
                "Lirys:Healing_Potion",
                0
        );
    }
}
