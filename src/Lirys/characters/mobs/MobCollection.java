package Lirys.characters.mobs;

import java.util.HashMap;
import java.util.Map;

public class MobCollection {
    private int mobID = 0;

    public static final Map<Integer, Mobs> MOB_DICTIONARY = new HashMap<>();

    public static final MobCollection MOB_COLLECTION = new MobCollection();

    //Methods
    public Mobs addMob(Mobs Mob){
        mobID++;
        return MOB_DICTIONARY.putIfAbsent(mobID, Mob);
    }

    // Getters & Setters
    public int getSize(){
        return MOB_DICTIONARY.size();
    }

    public Mobs getMob(int Int){
       return MOB_DICTIONARY.get(Int);
    }
}
