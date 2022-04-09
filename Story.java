package com.LirysBoo.Logic;

public class Story {

	public static void intro() {
		GameLogic.scrollingClear();
		
		System.out.println("Your little brother had caught a disease that rarely appears. The doctors said that");
		System.out.println("the disease can be cured and so were relieved. But they said the cure can only be obtained");
		System.out.println("by getting a certain herb in the northern mountains. A glowing fruit in a the west forest. And");
		System.out.println("a branch of a tree that only exists within a dungeon. Upon hearing that, you set your mind to");
		System.out.println("start your journey but there are dangerous creatures roaming around your country. Your brother");
		System.out.println("tried to stop you but you were determined to go for your beloved brother.");
		
		GameLogic.enterAnythingToContinue();
	}
	
	public static void firstAdventure() {
		
		System.out.println("You started your journey into the northern mountains. It is said that a enchanted herb is found there.");
	}

}
