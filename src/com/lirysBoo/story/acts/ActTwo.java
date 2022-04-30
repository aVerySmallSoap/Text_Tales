package com.lirysBoo.story.acts;

import com.lirysBoo.logic.GameLogic;
import com.lirysBoo.logic.Helper;

import static com.lirysBoo.logic.GameLogic.*;

/**
 * Chapters of the second act
 * <p>
 * {@code ActTwo} functions the same as {@link ActOne}, but is instead used for the second act.
 * <br>
 *  It is used to simplify the retrieving of chapters, and to provide little logical operations to help with {@link GameLogic}
 */
public class ActTwo {

    //A variable used to check, whether the programme is on ACT_TWO
    public boolean isOnACTTwo = true;

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

    //Act Two Introduction
    public void intro(){
        Helper.scrollingClear();

        System.out.println("""
				Time for the second act.
				Where people die alone in this road of unforeseen dangers
				
				You finally arrived in your home town and was shocked to what you've seen. The mysterious lady has been taking care of your brother.
				You felt grateful and thanked her..
				
				You gave her the enchanted herb and glowing fruit and asked if she had any clue about the beautiful flower.
				She gave you directions to come to the south. The clue might be found on the there.""");
        Helper.enterAnythingToContinue();
        storyChap++;
    }

    //The first chapter of the act
    public void ChapterOne(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Chapter 1");
        System.out.println("""
                After you made sure that your brother is okay, you traveled again to the south. The mysterious lady said
                that a certain man knows where the flower is and on what dungeon it resides in.. You asked to the residents there but
                an enemy suddenly appeared!""");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    //The second chapter of the act
    public void ChapterTwo(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Chapter 2");
        System.out.println("""
                A man approached you and it seemed he was the man you were searching for..
                He was impressed of how you defeated the enemy.

                Rumors says that the beautiful flower exist in a dungeon full of all kinds of enemy. The man led you to it's
                entrance, but it is up to you how you'll find it.. You began your journey..""");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    //The third chapter of the act
    public void ChapterThree(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Chapter 3");
        System.out.println("""
                You found a paper stuck in the enemy's clothes. It was a map for the flower! You followed the track
                in the map and arrived at a gate. It seems it needs a key to open the gate! Unexpectedly, you saw the key
                next to the gate but there is an enemy guarding that gate.""");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    //The fourth chapter of the act
    public void ChapterFour(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Chapter 4");
        System.out.println("""
                After defeating the enemy you went after the key and opened the gate.. At last you found the flower!
                It was a beautiful transparent flower and it looked like water in a shape of a flower.. You were surprised
                that the roots of this flower are glowing.. You investigated a little longer and the reason it survived
                without sunlight is because of the stream below that supports the flower. As you were about to cut and take
                the flower, you suddenly felt bad and hesitated. It was a decision whether to keep this flower alive or
                saving your brother...

                After a long thought.. you decided to keep this flower alive and only took the flower petals that were on
                the ground. You decided to go home after that but as you were about to reach the entrance""");
        Helper.enterAnythingToContinue();
        GameLogic.encounter();
    }

    //Act Two Outro
    public void Outro(){
        Helper.scrollingClear();
        Helper.Header("Act 2 : Ending");
        System.out.println("""
                You arrived in your hometown victorious but also bitter. Hoping that the flower petal was enough of
                an ingredient for the cure. When you came to your house, the mysterious lady congratulated you for not
                taking the flower and let it stay as it is.. You asked how come she knew about it and to your surprise!
                The lady turned into an enchantress! She began to mix together the ingredients, made the cure, and gave
                the cure to your brother.. It only took a day but your brother already healed! You were overjoyed and
                thanked the enchantress with all your heart..

                That night.. you dreamt of the kid who had the same symptoms of your brother.. what he said to your dream
                shocked you, for he said.. 'Do not trust the enchantress'..""");
        Helper.enterAnythingToContinue();
        storyACT++;
        isOnACTTwo = false;
    }
}
