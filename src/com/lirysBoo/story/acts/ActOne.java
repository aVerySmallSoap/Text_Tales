package com.lirysBoo.story.acts;

import com.lirysBoo.logic.GameLogic;
import com.lirysBoo.logic.Helper;

import java.io.IOException;

import static com.lirysBoo.logic.GameLogic.*;

/**
 * Chapters of the first Act
 * <p>
 * {@code ActOne} acts as a reference for different chapters in the first act.
 * <br>
 *  It is used to simplify the retrieving of chapters, and to provide little logical operations to help with {@link GameLogic}
 */
public class ActOne {

    //A variable used to check, whether the programme is on ACT_ONE
    public boolean isOnACTOne = true;

    /**
     * {@code getChapter} is a method which takes in a number to reference the code to its assigned method/chapter.
     *
     * @param Chapter references a number to a chapter
     */
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

    //Act One Introduction
    public void intro(){
        Helper.scrollingClear();

        System.out.println("""
				Your little brother had caught a disease that rarely appears. The doctors said that the disease can be cured and so were relieved.
				But they said the cure can only be obtained by getting a certain herb in the northern mountains.
				A glowing fruit in a the west forest and a branch of a tree that only exists within a dungeon.
				Upon hearing that, you set your mind to start your journey but there are dangerous creatures roaming around your country.
				Your brother tried to stop you but you were determined to go for your beloved brother.""");

        Helper.enterAnythingToContinue();

        attempts++;

        try {
            fileSaver();
        } catch (IOException e) {
            e.printStackTrace();
        }

        storyChap++;
    }

    //The first chapter of the act
    public void ChapterOne(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Chapter 1");
        System.out.println("""
                You met the doctor on the path towards the northern mountains, He gave you 5 healing potions for good luck.
                You started your journey into the northern mountains. On the way, you met a lone traveler —
                "What's this? Enchanted herb? I have heard rumors of such plant, they say that seven travelers have gone to look but never came back."
                He started to walk away, bearing the information in mind, you started to resolve yourself and continued to forge onwards.""");

        currentSelectedItem = consumables.getItem(0);
        currentSelectedItem.addItemCount(5);
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    //The second chapter of the act
    public void ChapterTwo(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Chapter 2");
        System.out.println("""
                At last you found the enchanted herb! You quickly went down and exited the mountains as to not encounter an enemy
                again. After the enchanted herb, you planned to obtain the glowing fruit in the western forest. Since you are in the northern
                side of the country. You decided to take a horse and make it your companion throughout the journey...
                Luckily you found an empty stable. However, you found an enemy there...""");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    //The third chapter of the act
    public void ChapterThree(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Chapter 3");
        System.out.println("""
                You hurriedly took a horse after you defeated the enemy! You have no time to spare and went your way towards the west..
                After you arrived at your destination, many warned you not to enter to the dark and misty forest, nonetheless you are
                determined to enter it for your brother. You began your search for the glowing fruit.""");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    //The fourth chapter of the act
    public void ChapterFour(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Chapter 4");
        System.out.println("""
                It took days and days to search for the glowing fruit. However you still didn't get a single clue or a hint
                of its location. You didn't let discouragement reach your heart for you would do anything to save your one and only family.
                As you are walking by an unknown path. You found a swamp filled with mist. You wondered why a tree is in the middle
                of the swamp and how it survived. To your surprise, you saw the glowing fruit! As you went for the fruit, it seems
                that there are enemies awaiting ahead of you.""");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    //Act One Outro
    public void Outro(){
        Helper.scrollingClear();
        Helper.Header("Act 1 : Outro");
        System.out.println("""
                You stand victorious above the enemy that you just had defeated.. Finally, you reached and took the glowing fruit.
                You quickly went back to the entrance of the forest. Luckily you didn't encounter another enemy again.. After you rested to
                an inn. It seemed you do not have the clue on which dungeon the beautiful flower resides in.
                
                In the morning after that, you decided to go back to your town and ask the mysterious lady and check on your brother.""");
        Helper.enterAnythingToContinue();
        storyChap = 0;
        storyACT++;
        isOnACTOne = false;
    }
}
