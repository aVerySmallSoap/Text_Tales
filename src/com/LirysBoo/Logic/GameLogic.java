package com.LirysBoo.Logic;
import com.LirysBoo.Enemies.Player;
import com.LirysBoo.Enemies.mobs.BasicMobs;
import static com.LirysBoo.Enemies.mobs.BasicMobs.basicMobsList;
import java.io.*;
import java.util.Scanner;

public class GameLogic {
    public String name;
    public final Scanner scanner = new Scanner(System.in);
    public static boolean isGameRunning = true;
    private final Player player = new Player(name);
    private final BasicMobs basicMobs = new BasicMobs();
    private final int storyChap = 0;
    private int attempts; //iterate me to finish a story!
    private final File saveFile = new File("savedAttempts");

    // Helper methods

    //Clears the console
    public void scrollingClear(){
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }
    }

    //Wait on player action
    public void enterAnythingToContinue(){
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
                nameSet = true;
                System.out.println("I am an example of a story. Nothing much but just to fill in shit.\n"
                        + "Nevertheless, welcome! " + name); // remove me
                enterAnythingToContinue();
            }
        }while (!nameSet);
    }

    //WIP Save system
    private void setAttempts(int attempts){
        try {
            FileWriter numberOfAttempts = new FileWriter("savedAttempts");
            numberOfAttempts.write("Your number of attempts: " + attempts);
            numberOfAttempts.close();
        } catch (IOException e) {
            System.out.println("Something has occurred! And I don't know what and where!");
            e.printStackTrace();
        }
    }

    private void getAttempts(){
        try {
            FileReader numberOfAttempts = new FileReader("savedAttempts");
            char[] r = new char[100];
            numberOfAttempts.read(r);
            for (char c: r) {
                if(c == attempts){
                    setAttempts(attempts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: BattleSystem() -> desBOO
    //private void battleSystem(){} finish me!
    /*
    if possible, include an Encounter() method to generate random encounters
     */

    /**
     * Main Game Logic
     * @return game
     */
    public void gameRunning(){
        startScreen();
        if(saveFile.exists()){
            attempts++;
        } else if (!saveFile.exists())
        setAttempts(attempts);
        attempts++;
        System.out.println(attempts);
        while (isGameRunning){


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
