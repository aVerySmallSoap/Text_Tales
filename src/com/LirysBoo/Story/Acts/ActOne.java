package com.LirysBoo.Story.Acts;
import com.LirysBoo.Logic.GameLogic;
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
        GameLogic.scrollingClear();

        System.out.println("""
				Your little brother had caught a disease that rarely appears. The doctors said that the disease can be cured and so were relieved.
				But they said the cure can only be obtained by getting a certain herb in the northern mountains.
				A glowing fruit in a the west forest and a branch of a tree that only exists within a dungeon.
				Upon hearing that, you set your mind to start your journey but there are dangerous creatures roaming around your country.
				Your brother tried to stop you but you were determined to go for your beloved brother.""");
        enterAnythingToContinue();
        storyChap++;
    }

    void ChapterOne(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Chapter 1");
        System.out.println("You started your journey into the northern mountains. " +
                "It is said that a enchanted herb is found there.");
        GameLogic.encounter();
    }
    //Extend the story please thank youuu :D
    void ChapterTwo(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Chapter 2");
        System.out.println("Test 2");
        GameLogic.encounter();
    }

    void ChapterThree(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Chapter 3");
        System.out.println("Test 3");
        GameLogic.encounter();
    }

    void ChapterFour(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Chapter 4");
        System.out.println("Test 4");
        GameLogic.encounter();
    }

    void Outro(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Outro");
        System.out.println("Test 4");
        isOnACTOne = false;
        storyACT++;   
    }
}
