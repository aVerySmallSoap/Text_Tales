package com.LirysBoo.Story.Acts;
import com.LirysBoo.Logic.GameLogic;
import com.LirysBoo.Logic.Helper;
import com.LirysBoo.Story.Story;
import static com.LirysBoo.Logic.GameLogic.*;

public class ActOne implements Story {

    public boolean isOnACTOne = true;

    public void getChapter(int Chapter){
        switch (Chapter){
            case 0 -> intro();
            case 1 -> ChapterOne();
            case 2 -> ChapterTwo();
            case 3 -> ChapterThree();
            case 4 -> ChapterFour();
            case 5 -> Outro();
            default -> System.out.println(" Chapter not found");
        }
    }

    void intro(){
        Helper.scrollingClear();

        System.out.println("""
				Your little brother had caught a disease that rarely appears. The doctors said that the disease can be cured and so were relieved.
				But they said the cure can only be obtained by getting a certain herb in the northern mountains.
				A glowing fruit in a the west forest and a branch of a tree that only exists within a dungeon.
				Upon hearing that, you set your mind to start your journey but there are dangerous creatures roaming around your country.
				Your brother tried to stop you but you were determined to go for your beloved brother.""");

        Helper.enterAnythingToContinue();
        storyChap++;
    }

    void ChapterOne(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Chapter 1");
        System.out.println("""
                You met the doctor on the path towards the northern mountains, He gave you 5 healing potions for good luck.
                You started your journey into the northern mountains. On the way, you met a lone traveler —
                "What's this? Enchanted herb? I have heard rumors of such plant, they say that seven travelers have gone to look but never came back."
                He started to walk away, bearing the information in mind, you started to resolve yourself and continued to forge onwards.""");

        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }
    //Extend the story please thank you :D
    void ChapterTwo(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Chapter 2");
        System.out.println("Test 2");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterThree(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Chapter 3");
        System.out.println("Test 3");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterFour(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Chapter 4");
        System.out.println("Test 4");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    void Outro(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Outro");
        System.out.println("Test 4");
        Helper.enterAnythingToContinue();
        isOnACTOne = false;
        storyChap = 0;
        storyACT++;   
    }
}
