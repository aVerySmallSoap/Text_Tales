package com.lirysBoo.logic;
import static com.lirysBoo.characters.mobs.BasicMobs.basicMobsList;
import static com.lirysBoo.characters.mobs.IntermediateMobs.intermediateMobsList;
import com.lirysBoo.characters.Character;
import com.lirysBoo.characters.Player;
import com.lirysBoo.characters.mobs.BasicMobs;
import com.lirysBoo.characters.mobs.IntermediateMobs;
import com.lirysBoo.logic.items.Consumables;
import com.lirysBoo.story.acts.ActOne;
import com.lirysBoo.story.acts.ActTwo;
import javax.swing.JOptionPane;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GameLogic{

    private static final UserActions userActions = new UserActions();

    private static final ActOne ActOne = new ActOne();

    private static final ActTwo ActTwo = new ActTwo();

    public static final Scanner scanner = new Scanner(System.in);

    public static Consumables consumables;

    public static Player player;

    public static Character mob;

    public static String name;

    public static boolean isGameRunning = true, onGoingBattle = true;

    public static int storyChap = 0, storyACT = 1;

    //Main feature methods
    //TODO: finish gameLogic

    //Start screen prompt
    public void startScreen(){
        boolean nameSet = false;
        Helper.Separator(10);
        System.out.println("""
                Welcome to Text-Tales!
                A simple text-based RPG-adventure game
                Created by Lirys & Desiree""");
        Helper.Separator(10);
        Helper.enterAnythingToContinue();
        BasicMobs.generateMobs();
        IntermediateMobs.generateMobs();
        consumables.init();
        do{
            Helper.scrollingClear();
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
        Helper.Header("Victory!");
        System.out.println(mob.getName() + " is defeated.");
        Helper.Separator(20);
        mob.setHP(mob.getBaseMaxHP());
        storyChap++;
        Helper.enterAnythingToContinue();
    }

    //When the player has lost the battle(game)
    public static void gameOver(String deathReason){
        Helper.Header("Game Over!");
        System.out.println(deathReason);
        JOptionPane.showMessageDialog(
                null,
                "You were slain by " + mob.getName()
                        + "\n A fucking " + mob.getName() + ". You loser");
        ActOne.isOnACTOne = false; ActTwo.isOnACTTwo = false; //TODO: If possible, optimize this line
    }

    //WIP Save system
    //TODO: Save system

    //Battle system
    public static void battleSystem(){
        Helper.scrollingClear();
        while(onGoingBattle){
            mob.getStats();
            player.getStats();
            Helper.Separator(10);
            if(player.usedHeal){
                System.out.println("Battle log");
                Helper.Separator(5);
                System.out.println(player.getName() + " healed for 25");
                System.out.println(mob.getName() + " dealt " + mob.getAttack() + " to " + player.getName());
                player.usedHeal = false;
            }else{
                System.out.println("Battle log");
                Helper.Separator(5);
                System.out.println(mob.getName() + " dealt " + mob.getAttack() + " to " + player.getName());
                System.out.println(player.getName() + " dealt " + player.getAttack() + " to " + mob.getName());
            }
            Helper.Separator(10);
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
            Helper.Skipper();
            while(ActOne.isOnACTOne){
                ActOne.getChapter(storyChap);
            }
            while(ActTwo.isOnACTTwo){
                ActTwo.getChapter(storyChap);
            }

            if(storyACT >= 3){
                JOptionPane.showMessageDialog(null, "You've Won!");
                isGameRunning = false;
            }
        }
    }

} //End
