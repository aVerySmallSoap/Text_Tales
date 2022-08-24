package Lirys.logic.items;

public class Consumables extends Items{

    public Consumables(){}

    public Consumables(String itemName, String itemStringTag, int itemNumberTag, int count){
        super(itemName, itemStringTag, itemNumberTag, count);
        ITEMS_STRING_COLLECTION.put(this.getITEM_STRING_TAG(), this);
        ITEMS_NUMBER_COLLECTION.put(this.getITEM_NUMBER_TAG(), this);
    }

    public Consumables(String itemName, String itemTag, int count){
        super(itemName, itemTag, count);
        ITEMS_STRING_COLLECTION.put(this.getITEM_STRING_TAG(), this);
    }

    public Consumables(String itemName, int itemTag, int count){
        super(itemName, itemTag, count);
        ITEMS_NUMBER_COLLECTION.put(this.getITEM_NUMBER_TAG(), this);
    }

    static Consumables healthPot = new Consumables(
            "Healing Potion",
            "Lirys:Healing_Potion",
            0,
            0
    );

    @SuppressWarnings("unused")
    public void init(){
        final Consumables healthPot;
    }
}
