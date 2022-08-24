package Lirys.logic.items;

import Lirys.logic.Helper;

import java.util.*;

public abstract class Items {
    protected static final Map<String, Items> ITEMS_STRING_COLLECTION = new HashMap<>();
    protected static final Map<Integer, Items> ITEMS_NUMBER_COLLECTION = new HashMap<>();

    private String itemName, ITEM_STRING_TAG;

    private int itemCount, ITEM_NUMBER_TAG;

    public Items(){}

    public Items(String itemName, String itemStringTag, int itemNumberTag, int count){
        this.itemName = itemName;
        this.ITEM_STRING_TAG = itemStringTag;
        this.ITEM_NUMBER_TAG = itemNumberTag;
        this.itemCount = count;
    }

    public Items(String itemName, String itemTag, int count){
        this.itemName = itemName;
        this.ITEM_STRING_TAG = itemTag;
        this.itemCount = count;
    }

    public Items(String itemName, int itemTag, int count){
        this.itemName = itemName;
        this.ITEM_NUMBER_TAG = itemTag;
        this.itemCount = count;
    }

    // Getters and Setters

    public void getStringItemCollection(){
        ITEMS_STRING_COLLECTION.values();
        ITEMS_NUMBER_COLLECTION.values();
    }

    public int getItemCount() { return itemCount;}

    public String getITEM_STRING_TAG() {return ITEM_STRING_TAG;}

    public int getITEM_NUMBER_TAG() {return ITEM_NUMBER_TAG;}

    public String getItemName() {return itemName;}

    public void setItemCount(int Amount){this.itemCount = Amount;}

    @SuppressWarnings("unused")
    public void addItem(String stringMetaID, int numberMetaID, Items items){
        ITEMS_STRING_COLLECTION.put(stringMetaID, items);
        ITEMS_NUMBER_COLLECTION.put(numberMetaID, items);
    }

    @SuppressWarnings("unused")
    public void addItem(String metaID, Items items){
        ITEMS_STRING_COLLECTION.put(metaID, items);
    }

    public void addItem(int metaID, Items items){
        ITEMS_NUMBER_COLLECTION.put(metaID, items);
    }

    public Items getItem(String itemTag){
        return ITEMS_STRING_COLLECTION.get(itemTag);
    }

    public Items getItem(int itemTag){
        return ITEMS_NUMBER_COLLECTION.get(itemTag);
    }

    public void getItemsInventory(){
        for (String metaID: ITEMS_STRING_COLLECTION.keySet()){
            if (metaID.equals("Lirys:Healing_Potion")){
                Items item = ITEMS_STRING_COLLECTION.get(metaID);
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
