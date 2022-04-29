package com.lirysBoo.logic.items;

public class Consumables extends Items{

    public Consumables(){}

    public Consumables(String itemName, String itemTag, int itemID, int count){
        super(itemName, itemTag, itemID, count);
        itemsList.add(this);
    }

    @SuppressWarnings("unused")
    public void init(){
        Consumables healthPot = new Consumables(
                "Healing Potion",
                "Lirys_healingPotion",
                0,
                0
        );
    }
}
