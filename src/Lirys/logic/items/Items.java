package Lirys.logic.items;

import Lirys.logic.Helper;

import java.util.*;

public abstract class Items {
    protected static final Map<String, Items> ITEMS_COLLECTION = new HashMap<>();

    private String itemName, ITEM_TAG;

    private int itemCount;

    public Items(){}

    public Items(String itemName, String itemTag, int count){
        this.itemName = itemName;
        this.ITEM_TAG = itemTag;
        this.itemCount = count;
    }

    // Getters and Setters
    public int getItemCount() { return itemCount;}

    public String getITEM_TAG() {return ITEM_TAG;}

    public String getItemName() {return itemName;}

    public void setItemCount(int Amount){this.itemCount = Amount;}

    public void addItem(String metaID, Items items){
        ITEMS_COLLECTION.put(metaID, items);
    }

    public Items getItem(String itemTag){
        return ITEMS_COLLECTION.get(itemTag);
    }

    public void getItemsInventory(){
        for (String metaID: ITEMS_COLLECTION.keySet()){
            if (metaID.equals("Lirys:Healing_Potion")){
                Items item = ITEMS_COLLECTION.get(metaID);
                System.out.println(item.getItemName());
                System.out.println("Amount: " + item.getItemCount());
                Helper.Separator(5);
            }
        }
    }

    public void addItemCount(int Amount){
        int count = this.itemCount + Amount;
        this.setItemCount(count);
    }

    public void removeItemCount(int Amount){
        int count = this.itemCount - Amount;
        this.setItemCount(count);
    }
}
