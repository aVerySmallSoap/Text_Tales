package com.LirysBoo.Logic.Items;
import java.util.ArrayList;
import java.util.List;

public interface Items {
   List<Items> items = new ArrayList<>();

    static void init(){
        Consumables.init();
    }
}
