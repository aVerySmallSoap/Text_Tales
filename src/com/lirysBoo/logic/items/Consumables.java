package com.lirysBoo.logic.items;

public class Consumables extends Items{

    private String itemName;

    private String ITEM_TAG;

    private int itemCount;

    private int itemID;

    //Add consumables

    public Consumables(){}

    public Consumables(String itemName, String itemTag, int itemID, int count){
        this.itemName = itemName;
        this.ITEM_TAG = itemTag;
        this.itemID = itemID;
        this.itemCount = count;
        itemsList.add(this);
    }

    public int getItemCount() { return itemCount;}

    public int getItemID()  { return itemID;}

    public String getItemName() {return itemName;}

    public String getITEM_TAG() {return ITEM_TAG;}

    public void setItemCount(int Amount){this.itemCount = Amount;}

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
