package Lirys.logic.items;

import Lirys.logic.Helper;

import java.util.*;

public abstract class Items {
    protected static final Map<String, Items> ITEMS_STRING_COLLECTION = new HashMap<>();

    protected static final Map<Integer, Items> ITEMS_NUMBER_COLLECTION = new HashMap<>();

    protected static final Map<Integer, Items> PLAYER_INVENTORY = new HashMap<>(); //Slot, Item

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

    public void getItemDictionary(){
        ITEMS_STRING_COLLECTION.forEach(
                (itemID, itemName) -> {
                    for (int i = 0; i < ITEMS_STRING_COLLECTION.size(); i++) {
                        System.out.println("Entry #"+i+": " + itemID + ", " + itemName.getItemName());
                    }
                }
        );

        ITEMS_NUMBER_COLLECTION.forEach(
                (itemID, itemName) -> {
                    for (int i = 0; i < ITEMS_NUMBER_COLLECTION.size(); i++) {
                        System.out.println("Entry #"+i+": " + itemID + ", " + itemName.getItemName() );
                    }
                }
        );
    }

    public void getStringItemCollection(){
        ITEMS_STRING_COLLECTION.forEach(
                (itemID, itemName) -> {
                    for (int i = 0; i < ITEMS_STRING_COLLECTION.size(); i++) {
                        System.out.println("Entry #"+i+": " + itemID + ", " + itemName.getItemName());
                    }
                }
        );
    }

    public void getNumberItemCollection(){
        ITEMS_NUMBER_COLLECTION.forEach(
                (itemID, itemName) -> {
                    for (int i = 0; i < ITEMS_NUMBER_COLLECTION.size(); i++) {
                        System.out.println("Entry #"+i+": " + itemID + ", " + itemName.getItemName() );
                    }
                }
        );
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

    public void addItemToPlayerInventory(Items Item){
        for (int i = 0; i < PLAYER_INVENTORY.size(); i++) {
            if (PLAYER_INVENTORY.get(i) == null){
                PLAYER_INVENTORY.put(Item.getITEM_NUMBER_TAG(), Item);
            }else{
                i++;
            }
        }
    }

    public void getItemsFromPlayerInventory(){
        PLAYER_INVENTORY.forEach(
                (inventorySlot, Item) -> {
                    System.out.println("Slot: " + inventorySlot);
                    System.out.println("Name: " + Item.getItemName());
                    System.out.println("Count: " + Item.getItemCount());
                    Helper.Separator(5);
                }
        );
    }

    public static void removeItemFromPlayerInventory(){

    }

    public Items getItem(String itemTag){
        return ITEMS_STRING_COLLECTION.get(itemTag);
    }

    public Items getItem(int itemTag){
        return ITEMS_NUMBER_COLLECTION.get(itemTag);
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
