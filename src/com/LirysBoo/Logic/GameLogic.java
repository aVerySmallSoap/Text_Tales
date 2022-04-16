package com.LirysBoo.Logic;
import com.LirysBoo.Characters.Character;
import com.LirysBoo.Characters.Player;
import com.LirysBoo.Characters.mobs.BasicMobs;
import static com.LirysBoo.Characters.mobs.BasicMobs.basicMobsList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GameLogic {
    private static final BasicMobs basicMobs = new BasicMobs();
    private static final UserActions userActions = new UserActions();
    private static final Scanner scanner = new Scanner(System.in);
    public static Player player;
    public static Character mob;
    public static String name;
    public static boolean isGameRunning = true;
    public static boolean onGoingBattle = true;
    public static int storyChap = 0;

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
    public static void header(String title){
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
    public static void separator(int lineAmount){
        for (int i = 0; i < lineAmount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //Main feature methods
    //TODO: finish gameLogic

    //Start screen prompt
    public void startScreen(){
        boolean nameSet = false;
        separator(10);
        System.out.println("""
                Welcome to Text-Tales!
                A simple text-based RPG-adventure game
                Created by Lirys & Desiree""");
        separator(10);
        enterAnythingToContinue();
        basicMobs.generateBasicMobs(); // initializes basicMobs

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
        int listSize = basicMobsList.size();
        int randNum = ThreadLocalRandom.current().nextInt(0, listSize);
        onGoingBattle = true; // resets the battleSystem


        for(int i = 0; i < listSize; i++) {
            if(i == randNum) {
                mob = basicMobsList.get(i); // sets mob variable to a random mob in the arrayList basicMobList
                System.out.println("You encountered a " + mob.getName());
                userActions.fightOrFlight();
            }
        }
    }

    //When the player has won a battle
    public static void battleWon(){
        header("Victory!");
        System.out.println(mob.getName() + " is defeated.");
        separator(20);
        mob.setHP(mob.getBaseMaxHP());
        enterAnythingToContinue();
        storyChap++;
    }

    //When the player has lost the battle(game)
    public static void gameOver(String deathReason){
        header("Game Over!");
        System.out.println(deathReason);
        isGameRunning = false;
    }

    //WIP Save system
    //TODO: Save system


    //Battle system
    public static void battleSystem(){
        scrollingClear();
        while(onGoingBattle){
            mob.printStats(mob);
            player.printStats(player);
            separator(10);
            if(player.usedHeal){
                System.out.println("Battle log");
                separator(5);
                System.out.println(player.getName() + " healed for 25");
                System.out.println(mob.getName() + " dealt " + mob.getAttack() + " to " + player.getName());
                player.usedHeal = false;
            }else{
                System.out.println("Battle log");
                separator(5);
                System.out.println(mob.getName() + " dealt " + mob.getAttack() + " to " + player.getName());
                System.out.println(player.getName() + " dealt " + player.getAttack() + " to " + mob.getName());
            }
            separator(10);
            userActions.Actions();
        }
    }

    /**
     * Main Game Logic
     *
     */
    public void gameRunning(){

        do{
            startScreen(); // fix text skip bug
            scrollingClear();
            header("Blank");
            enterAnythingToContinue();
            Story.intro();
            Story.actOne_ChapterOne();
            Story.actOne_ChapterOne();

            if(storyChap > 4){
                System.out.println("You've won!");
                isGameRunning = false;
            }
        }while (isGameRunning);
    }

} //End
