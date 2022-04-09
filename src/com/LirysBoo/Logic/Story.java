package com.LirysBoo.Logic;
import static com.LirysBoo.Logic.GameLogic.enterAnythingToContinue;
import static com.LirysBoo.Logic.GameLogic.name;
import static com.LirysBoo.Logic.GameLogic.storyChap;

public class Story {

	public static void intro() {
		GameLogic.scrollingClear();

		System.out.println("Hi " + name + "!");
		System.out.println("Join us in this journey of adventure! Well then, let's start! \n");
		System.out.println("""
				Your little brother had caught a disease that rarely appears. The doctors said that the disease can be cured and so were relieved.
				 But they said the cure can only be obtained by getting a certain herb in the northern mountains.
				 A glowing fruit in a the west forest and a branch of a tree that only exists within a dungeon.
				 Upon hearing that, you set your mind to start your journey but there are dangerous creatures roaming around your country.
				 Your brother tried to stop you but you were determined to go for your beloved brother.""");
		enterAnythingToContinue();
		storyChap++;
	}
	
	public static void firstAdventure() {

		GameLogic.scrollingClear();
		System.out.println("You started your journey into the northern mountains. It is said that a enchanted herb is found there.");
		GameLogic.encounter();
	}

}
