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
				Your little brother had caught a disease that rarely appears. You went to all hospitals but all the doctors said that 
				the disease can't be cured. As you were thinking and agonizing over the situation, you saw a child that had the same
				symptoms as your brother. It seemed he had started to heal.. You asked the child but to its dismay, he started to ran
				away.. One afternoon, a mysterious woman said that the disease can be cured only if you obtain a certain herb in the
				northern mountains, a glowing fruit in the western forest, and a mysterious yet beautiful flower that only exists
				within a dungeon. Upon hearing that, you set your mind to start your journey but there are dangerous creatures roaming
				around your country. Your brother tried to stop you but you are determined to go for your beloved brother.""");
        enterAnythingToContinue();
        storyChap++;
    }

    void ChapterOne(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Chapter 1");
        System.out.println("You started your journey into the northern mountains. " +
                "It is said that a enchanted herb can be found there.");
        enterAnythingToContinue();
        GameLogic.encounter();
        
    }
    //Extend the story please thank you :D
    void ChapterTwo(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Chapter 2");
        System.out.println("At last you found the enchanted herb! You quickly went down and exited the mountains as to not encounter an enemy\n"
        		+ "again. After the enchanted herb, you planned to obtain the glowing fruit in the western forest. Since you are in the northern\n"
        		+ "side of the country. You decided to take a horse and make it your companion throughout the journey.. \nLuckily you found an"
        		+ " empty stable. However, you found an enemy there...");
        enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterThree(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Chapter 3");
        System.out.println("You hurriedly took a horse after you defeated the enemy! You have no time to spare and went your way towards the west..\n"
        		+ "After you arrived at your destination, many warned you not to enter to the dark and misty forest, nonetheless you are\n"
        		+ "determined to enter it for your brother. You began your search for the glowing fruit.");
        enterAnythingToContinue();
        GameLogic.encounter();
    }

    void ChapterFour(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Chapter 4");
        System.out.println("It took days and days to search for the glowing fruit. However you still didn't get a single clue or a hint\n"
        		+ "of its location. You didn't let discouragement reach your heart for you would do anything to save your one and only family.\n"
        		+ "As you are walking by an unknown path. You found a swamp filled with mist. You wondered why a tree is in the middle\n"
        		+ "of the swamp and how it survided. To your surprise, you saw the glowing fruit! As you went for the fruit, it seems\n"
        		+ "that there are enemies awaiting ahead of you.");
        enterAnythingToContinue();
        GameLogic.encounter();
    }

    void Outro(){
        GameLogic.scrollingClear();
        GameLogic.Header("Act 1 : Outro");
        System.out.println("You stand victorious above the enemy that you just had defeated.. Finally, you reached and took the glowing fruit.\n"
        		+ "You quickly went back to the entrance of the forest. Luckily you didn't encounter another enemy again.. After you rested to\n"
        		+ "an inn. It seemed you do not have the clue on which dungeon the beautiful flower resides in.\n"
        		+ "\n"
        		+ "In the moring after that, you decided to go back to your town and ask the mysterious lady and check on your brother.");
        enterAnythingToContinue();
        isOnACTOne = false;
        storyChap = 0;
        storyACT++;   
    }
}
