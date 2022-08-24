package Lirys.logic;

import Lirys.characters.Player;
import Lirys.characters.mobs.MobCollection;
import Lirys.characters.mobs.Mobs;
import Lirys.logic.items.Consumables;
import Lirys.logic.items.Items;
import Lirys.story.acts.ActOne;
import Lirys.story.acts.ActTwo;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameLogic{

    private static final UserActions USER_ACTIONS = new UserActions();

    private static final ActOne ACT_ONE = new ActOne();

    private static final ActTwo ACT_TWO = new ActTwo();

    private static final File ATTEMPT_FILE_PATH = new File("Attempts.txt");

    private static final List<Integer> PARSED_NUMBERS = new ArrayList<>();

    public static final Scanner SCANNER = new Scanner(System.in);

    public static Consumables consumables = new Consumables();

    public static Items currentSelectedItem = null;

    public static Player player;

    public static Mobs mob;

    public static String name;

    public static boolean isGameRunning = true, onGoingBattle = true;

    public static int storyChap = 0, storyACT = 1, attempts;

    //Main feature methods

    //Start screen prompt
    public void startScreen(){
        boolean nameSet = false;

        try{
            if (!ATTEMPT_FILE_PATH.exists()){
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(ATTEMPT_FILE_PATH));
                fileWriter.write("Your number of attempts: " + attempts);
                fileWriter.close();
                fileLoader();
            }else {
                fileLoader();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        Helper.Separator(10);
        System.out.println("""
                Welcome to Text-Tales!
                A simple text-based RPG-adventure game
                Created by Lirys & Desiree""");
        Helper.Separator(10);
        System.out.println("Your number of attempts: " + PARSED_NUMBERS.get(0));
        Helper.Separator(10);
        Helper.enterAnythingToContinue();
        Mobs.generateMobs();
        consumables.init();
        do{
            Helper.scrollingClear();
            System.out.println("Enter your name: ");
            name = SCANNER.next();
            System.out.println("Are you sure? Y/N");
            char choice = SCANNER.next().charAt(0);
            player = new Player(name);
            if(String.valueOf(choice).equalsIgnoreCase("y")){
                nameSet = true;
            }
        }while (!nameSet);
    }

    public static void encounter() {
        int lowListSize = MobCollection.MOB_COLLECTION.getSize(), randNum;
        randNum = ThreadLocalRandom.current().nextInt(1, lowListSize);
        onGoingBattle = true;
        for(int i = 0; i < lowListSize; i++) {
            if(i == randNum) {
                mob = MobCollection.MOB_COLLECTION.getMob(i); // sets mob variable to a random mob in the arrayList basicMobList
                System.out.println("You encountered a " + mob.getName());
                USER_ACTIONS.fightOrFlight();
            }
        }
    }

    public static void mobRewards(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        currentSelectedItem = consumables.getItem("Lirys:Healing_Potion");
        consumables.addItemToPlayerInventory(currentSelectedItem);
        System.out.println(mob.getName() + " Dropped "+ randomNum + " " + currentSelectedItem.getItemName());
        currentSelectedItem.addItemCount(randomNum);
    }

    public static void battleWon(){
        Helper.Header("Victory!");
        System.out.println(mob.getName() + " is defeated.");
        Helper.Separator(20);
        mobRewards();
        mob.setHP(mob.getBaseMaxHP());
        storyChap++;
        Helper.enterAnythingToContinue();
    }

    public static void gameOver(String deathReason){
        Helper.Header("Game Over!");
        System.out.println(deathReason);
        JOptionPane.showMessageDialog(
                null,
                "You were slain by " + mob.getName()
                        + "\n Game Over.");
    }

    //Attempts Counter
    public static void fileLoader() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(ATTEMPT_FILE_PATH));
        String text;
        while ((text = fileReader.readLine()) != null){
            String s = text.replaceAll("\\D", "");
            PARSED_NUMBERS.add(Integer.parseInt(s));
            attempts = PARSED_NUMBERS.get(0);
        }
    }

    public static void fileSaver()throws IOException{
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(ATTEMPT_FILE_PATH));
        fileWriter.write("Your number of attempts: " + attempts);
        fileWriter.close();
    }

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
            USER_ACTIONS.Actions();
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
            while(ACT_ONE.isOnACTOne && isGameRunning){
                ACT_ONE.getChapter(storyChap);
            }
            while(ACT_TWO.isOnACTTwo && isGameRunning){
                ACT_TWO.getChapter(storyChap);
            }

            if(storyACT >= 3){
                JOptionPane.showMessageDialog(null, "You've Won!");
                attempts = 0;

                try {
                    fileSaver();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isGameRunning = false;
            }
        }
    }

} //End
