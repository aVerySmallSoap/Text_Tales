package com.LirysBoo.Story.Acts;
import com.LirysBoo.Logic.GameLogic;
import com.LirysBoo.Logic.Helper;
import com.LirysBoo.Story.Story;

import static com.LirysBoo.Logic.GameLogic.*;

public class ActTwo implements Story {

    public boolean isOnACTTwo = true;

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
				Time for the second act.
				Where people die alone in this road of unforeseen dangers""");
        Helper.enterAnythingToContinue();
        storyChap++;
    }
    //Extend the story please thank you :D
    void ChapterOne(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Chapter 1");
        System.out.println("You started your journey into the northern mountains. " +
                "It is said that a enchanted herb is found there.");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterTwo(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Chapter 2");
        System.out.println("Test 2");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterThree(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Chapter 3");
        System.out.println("Test 3");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterFour(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Chapter 4");
        System.out.println("Test 4");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    void Outro(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Ending");
        System.out.println("Test 4");
        Helper.enterAnythingToContinue();
        isOnACTTwo = false;
        storyACT++;
    }
}
