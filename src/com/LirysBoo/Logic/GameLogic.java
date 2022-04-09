package com.LirysBoo.Logic;
import com.LirysBoo.Characters.Player;
import com.LirysBoo.Characters.mobs.BasicMobs;
import static com.LirysBoo.Characters.mobs.BasicMobs.basicMobsList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GameLogic {
    public static String name;
    public static final Scanner scanner = new Scanner(System.in);
    public static boolean isGameRunning = true;
    private final Player player = new Player(name);
    private final static BasicMobs basicMobs = new BasicMobs();
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

    //Custom toInt Scanner for user choices
    public int userAction(String prompt, int userChoices){
        int input;
        do{
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            }catch (Exception e){
                input = -1;
                System.out.println("Invalid Action");
            }
        }while(input < 1 || input > userChoices); // Do-while check for inputs; should do more do-loops
        return input;
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
            if(String.valueOf(choice).equalsIgnoreCase("y")){
                System.out.println("Hello! " + name + "!");
                enterAnythingToContinue();
                nameSet = true;
            }
        }while (!nameSet);
    }

    public static void encounter() {
        int listSize = basicMobsList.size();
        int randNum = ThreadLocalRandom.current().nextInt(1, basicMobsList.size());

        for(int i = 0; i < listSize; i++) {
            if(i == randNum) {
                BasicMobs mob = basicMobsList.get(i);
                System.out.println("You encountered a " + mob.getName() + " in the northern mountains! You need to defeat it!");
            }
        }
    }

    //WIP Save system

    //TODO: BattleSystem() -> desBOO
    //private void battleSystem(){} finish me!
    /*
    if possible, include an Encounter() method to generate random encounters.
     */

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
