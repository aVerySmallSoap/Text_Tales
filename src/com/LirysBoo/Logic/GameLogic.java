package com.LirysBoo.Logic;
import com.LirysBoo.Characters.Character;
import com.LirysBoo.Characters.Player;
import com.LirysBoo.Characters.mobs.BasicMobs;
import static com.LirysBoo.Characters.mobs.BasicMobs.basicMobsList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GameLogic {
    private static Player player;
    private final static BasicMobs basicMobs = new BasicMobs();
    private static final UserActions userActions = new UserActions();
    private static final Scanner scanner = new Scanner(System.in);
    public static Character mob;
    public static String name;
    public static boolean isGameRunning = true;
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

    //Main feature methods
    //TODO: finish gameLogic

    //Start screen prompt
    public void startScreen(){
        boolean nameSet = false;
        System.out.println("""
                Welcome to Text-Tales!
                A simple text-based RPG-adventure game
                Created by Lirys & Desiree""");
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

    public static void encounter() {
        int listSize = basicMobsList.size();
        int randNum = ThreadLocalRandom.current().nextInt(0, listSize-1);


        for(int i = 0; i < listSize; i++) {
            if(i == randNum) {
                mob = basicMobsList.get(i);
                System.out.println("You encountered a " + mob.getName());
                userActions.fightOrFlight();
            }
        }
    }

    //WIP Save system


    //made for testing purposes
    public static void battleSystem(){
        scrollingClear();
        mob.printStats(mob);
        mob.setHP(player.Attack());
        mob.printStats(mob);
    }

    /**
     * Main Game Logic
     *
     */
    public void gameRunning(){
        startScreen();
        Story.intro();
        Story.firstAdventure();
        while (isGameRunning) {

            //If conditional is not final TODO: finish game conditions when battle system is done.
            if(storyChap >= 4){
                System.out.println("You've won!");
                isGameRunning = false;
            } else if (player.getHP() == 0){
                System.out.println("Try again loser.");
                isGameRunning = false;
            }
        }
    }

} //End
