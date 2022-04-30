package com.LirysBoo.Logic;
import static com.LirysBoo.Characters.mobs.BasicMobs.basicMobsList;
import static com.LirysBoo.Characters.mobs.IntermediateMobs.intermediateMobsList;
import com.LirysBoo.Characters.Character;
import com.LirysBoo.Characters.Player;
import com.LirysBoo.Characters.mobs.BasicMobs;
import com.LirysBoo.Characters.mobs.IntermediateMobs;
import com.LirysBoo.Story.Acts.ActOne;
import com.LirysBoo.Story.Acts.ActTwo;
import com.LirysBoo.Story.Story;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GameLogic implements Story {
    private static final UserActions userActions = new UserActions();
    private static final Scanner scanner = new Scanner(System.in);
    private static final ActOne ActOne = new ActOne();
    private static final ActTwo ActTwo = new ActTwo();
    public static Player player;
    public static Character mob;
    public static String name;
    public static boolean isGameRunning = true, onGoingBattle = true;
    public static int storyChap = 0, storyACT = 1;

    // Helper methods

    //Clears the console
    public static void scrollingClear(){
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }
    }

    //Wait on player action
    public static void enterAnythingToContinue(){
        System.out.println("Enter any key to continue...");
        scanner.nextLine();
    }

    //Title headers; Also servers as stoppers
    public static void Header(String title){
        for (int i = 0; i < 25; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(title);
        for (int j = 0; j < 25; j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //Separator method to separate large text segments
    public static void Separator(int lineAmount){
        for (int i = 0; i < lineAmount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //Spacer method to separate texts with white spaces
    public static void Spacer(int Amount){
        for (int i = 0; i < Amount; i++) {
            System.out.println();
        }
    }

    //Skipper method; Skips the enterAnyThingToContinue text bug
    private void Skipper(){
        scrollingClear();
        Header("Blank");
        enterAnythingToContinue();
    }

    //Main feature methods
    //TODO: finish gameLogic

    //Start screen prompt
    public void startScreen(){
        boolean nameSet = false;
        Separator(10);
        System.out.println("""
                Welcome to Text-Tales!
                A simple text-based RPG-adventure game
                Created by Lirys & Desiree""");
        Separator(10);
        enterAnythingToContinue();
        BasicMobs.generateMobs();
        IntermediateMobs.generateMobs();

        do{
            scrollingClear();
            System.out.println("Enter your name: ");
            name = scanner.next();
            System.out.println("Are you sure? Y/N");
            char choice = scanner.next().charAt(0);
            player = new Player(name);
            if(String.valueOf(choice).equalsIgnoreCase("y")){
                nameSet = true;
            }
        }while (!nameSet);
    }

    // Generates a random mob to battle the player
    public static void encounter() {
        int lowListSize = basicMobsList.size(), midListSize = intermediateMobsList.size(), randNum;
        if (storyACT == 1){
            randNum = ThreadLocalRandom.current().nextInt(0, lowListSize);
            onGoingBattle = true;
            for(int i = 0; i < lowListSize; i++) {
                if(i == randNum) {
                    mob = basicMobsList.get(i); // sets mob variable to a random mob in the arrayList basicMobList
                    System.out.println("You encountered a " + mob.getName());
                    userActions.fightOrFlight();
                }
            }
        }else if(storyACT == 2) {
            randNum = ThreadLocalRandom.current().nextInt(0, midListSize);
            onGoingBattle = true;
                for(int i = 0; i < midListSize; i++) {
                    if(i == randNum) {
                        mob = intermediateMobsList.get(i); // sets mob variable to a random mob in the arrayList basicMobList
                        System.out.println("You encountered a " + mob.getName());
                        userActions.fightOrFlight();
                    }
                }
            }
    }


    //When the player has won a battle
    public static void battleWon(){
        Header("Victory!");
        System.out.println(mob.getName() + " is defeated.");
        Separator(20);
        mob.setHP(mob.getBaseMaxHP());
        storyChap++;
        enterAnythingToContinue();
    }

    //When the player has lost the battle(game)
    public static void gameOver(String deathReason){
        Header("Game Over!");
        System.out.println(deathReason);
        ActOne.isOnACTOne = false; ActTwo.isOnACTTwo = false; //TODO: If possible, optimize this line
    }

    //WIP Save system
    //TODO: Save system


    //Battle system
    public static void battleSystem(){
        scrollingClear();
        while(onGoingBattle){
            mob.getStats();
            player.getStats();
            Separator(10);
            if(player.usedHeal){
                System.out.println("Battle log");
                Separator(5);
                System.out.println(player.getName() + " healed for 25");
                System.out.println(mob.getName() + " dealt " + mob.getAttack() + " to " + player.getName());
                player.usedHeal = false;
            }else{
                System.out.println("Battle log");
                Separator(5);
                System.out.println(mob.getName() + " dealt " + mob.getAttack() + " to " + player.getName());
                System.out.println(player.getName() + " dealt " + player.getAttack() + " to " + mob.getName());
            }
            Separator(10);
            userActions.Actions();
        }
    }

    /**
     * Main Game Logic
     *
     */
    public void gameRunning(){
        while (isGameRunning){
            startScreen();
            Skipper();
            while(ActOne.isOnACTOne){
                ActOne.getChapter(storyChap);
            }
            while(ActTwo.isOnACTTwo){
                ActTwo.getChapter(storyChap);
            }

            if(storyACT >= 3){
                System.out.println("The story ends here!");
                isGameRunning = false;
            }
        }
    }

} //End
