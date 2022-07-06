package Lirys.logic.items;

import Lirys.logic.Helper;

import java.util.ArrayList;
import java.util.List;

import static Lirys.logic.GameLogic.currentSelectedItem;

public abstract class Items {

    static List<Items> itemsList = new ArrayList<>();

    private String itemName, ITEM_TAG;

    private int itemCount, itemID;

    public Items(){}

    public Items(String itemName, String itemTag, int itemID, int count){
        this.itemName = itemName;
        this.ITEM_TAG = itemTag;
        this.itemID = itemID;
        this.itemCount = count;
    }

    // Getters and Setters
    public int getItemCount() { return itemCount;}
    @SuppressWarnings("unused")
    public int getItemID()  { return itemID;}

    public String getITEM_TAG() {return ITEM_TAG;}

    public String getItemName() {return itemName;}

    public void setItemCount(int Amount){this.itemCount = Amount;}

    public Items getItem(int itemID){
        for (int i = 0; i < itemsList.size(); i++) {
            if (i == itemID){
                currentSelectedItem = itemsList.get(i);
                return currentSelectedItem;
            }
        }
        return null;
    }
    // Method overloading
    @SuppressWarnings("unused")
    public Items getItem(String ITEM_TAG){
        for (Items a : itemsList) {
            var b = a.getITEM_TAG();
            if (b.equals(ITEM_TAG)) {
                currentSelectedItem = a;
                return currentSelectedItem;
            }
        }
        return null;
    }

    public void getItemsInventory(){
        for (Items item : itemsList) {
            System.out.println(item.getItemName());
            System.out.println("Amount: " + item.getItemCount());
            Helper.Separator(5);
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
