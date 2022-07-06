package Lirys.Tests;

import Lirys.characters.mobs.MobCollection;
import Lirys.characters.mobs.Mobs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MobCollectionTest {

    private final MobCollection underTest = new MobCollection();
    private final Mobs a = new Mobs("A",
            1,
            1,
            1 ,
            1);

    @Test
    void addsObjectToMap() {

        System.out.println(Arrays.toString(MobCollection.MOB_DICTIONARY.entrySet().toArray()));
        //passed
        Assertions.assertEquals(a, underTest.addMob(a));
    }

    @Test
    void getMob() {
        System.out.println(Arrays.toString(MobCollection.MOB_DICTIONARY.entrySet().toArray()));
        Assertions.assertEquals(a, underTest.getMob(1));
    }

    @Test
    void getSize(){
        Assertions.assertEquals(1, underTest.getSize());
    }
}