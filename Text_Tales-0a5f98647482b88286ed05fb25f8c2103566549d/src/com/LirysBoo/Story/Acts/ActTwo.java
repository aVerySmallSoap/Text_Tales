package com.LirysBoo.Story.Acts;
import com.LirysBoo.Logic.GameLogic;
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
        GameLogic.scrollingClear();

        System.out.println("""
				Time for the second act.
				Where people die alone in this road of unforeseen dangers
				
				You finally arrived in your home town and was shocked to what you've seen. The mysterious lady has 
				been taking care of your brother. You felt grateful and thanked her..
				
				You gave her the enchanted herb and glowing fruit and asked if she had any clue about the beautiful flower.
				She gave you directions to come to the south. The clue might be found on the there.""");
        enterAnythingToContinue();
        storyChap++;
    }
    //Extend the story please thank you :D
    void ChapterOne(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 2 : Chapter 1");
        System.out.println("After you made sure that your brother is okay, you traveled again to the south. The mysterious lady said\n"
        		+ "that a certain man knows where the flower is and on what dungeon it resides in.. You asked to the residents there but\n"
        		+ "an enemy suddenly appeared!");
        enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterTwo(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 2 : Chapter 2");
        System.out.println("A man approached you and it seemed he was the man you were searching for..\n"
        		+ "He was impressed of how you defeated the enemy.\n"
        		+ "\n"
        		+ "Rumors says that the beautiful flower exist in a dungeon full of all kinds of enemy. The man led you to it's\n"
        		+ "entrance, but it is up to you how you'll find it.. You began your journey..");
        enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterThree(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 2 : Chapter 3");
        System.out.println("You found a paper stucked in the enemy's clothes. It was a map for the flower! You followed the track\n"
        		+ "in the map and arrived at a gate. It seems it needs a key to open the gate! Unexpectedly, you saw the key\n"
        		+ "next to the gate but there is an enemy guarding that gate.");
        enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterFour(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 2 : Chapter 4");
        System.out.println("After defeating the enemy you went after the key and opened the gate.. At last you found the flower!\n"
        		+ "It was a beautiful transparent flower and it looked like water in a shape of a flower.. You were surprised\n"
        		+ "that the roots of this flower are glowing.. You investigated a little longer and the reason it survived\n"
        		+ "without sunlight is because of the stream below that supports the flower. As you were about to cut and take\n"
        		+ "the flower, you suddenlt felt bad and hesitated. It was a decision whether to keep this flower alive or\n"
        		+ "saving your brother...\n"
        		+ "\n"
        		+ "After a long thought.. you decided to keep this flower alive and only took the flower petals that were on\n"
        		+ "the ground. You decided to go home after that but as you were about to reach the entrance");
        enterAnythingToContinue();
        GameLogic.encounter();
    }

    void Outro(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 2 : Ending");
        System.out.println("You arrived in your hometown victorious but also bitter. Hoping that the flower petal was enough of\n"
        		+ "an indredient for the cure. When you came to your house, the mysterious lady congratulated you for not\n"
        		+ "taking the flower and let it stay as it is.. You asked how come she knew about it and to your surprise!\n"
        		+ "The lady turned into an enchantress! She bagan to mix together the ingredients, made the cure, and gave\n"
        		+ "the cure to your brother.. It only took a day but your brother already healed! You were overjoyed and\n"
        		+ "thanked the enchantress with all your heart..\n"
        		+ "\n"
        		+ "That night.. you dreamt of the kid who had the same symptoms of your brother.. what he saidto your dream\n"
        		+ "shocked you, for he said.. 'Do not trust the enchnatress'..");
        enterAnythingToContinue();
        isOnACTTwo = false;
        storyACT++;
    }
}
