package com.LirysBoo.Logic.Items;

public class Consumables extends Items{
    private String itemName;
    private String ITEM_TAG;
    private int itemCount, itemID;

    public Consumables(){}
    //Add consumables

    public Consumables(String itemName, String itemTag, int itemID, int count){
        this.itemName = itemName;
        this.ITEM_TAG = itemTag;
        this.itemID = itemID;
        this.itemCount = count;
        items.add(this);
    }

    public int getItemCount() { return itemCount;}
    public int getItemID()  { return itemID;}
    public String getItemName() {return itemName;}
    public String getITEM_TAG() {return ITEM_TAG;}
    public void setItemCount(int Amount){this.itemCount = Amount;}

    // functions
    public void consume(){}
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
