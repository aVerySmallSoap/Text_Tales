package com.LirysBoo.Logic;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.LirysBoo.Logic.GameLogic.*;

public class UserActions {
    private final Scanner scanner = new Scanner(System.in);

    //Custom toInt Scanner for user choices
    public int userChoices(String prompt, int userChoices){
        int input;
        do{
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            }catch (Exception e){
                System.out.println("Invalid Action");
                input = -1;
            }
        }while(input < 1 || input > userChoices); // Do-while check for inputs; should do more do-loops
        return input;
    }

    // Try for final fantasy style choice system
    public void Actions(){
        Spacer(3);
        System.out.println("""
                What will you do?
                1. Attack
                2. Heal
                3. Run
                """);
        System.out.print("->");
        int choice = scanner.nextInt();
        if(choice == 1){
            mob.setCurrentHP(player.Attack());
            player.setCurrentHP(mob.Attack());
            if(mob.HP <= 0){
                mob.setHP(0);
                scrollingClear();
                mob.printStats(mob);
                player.printStats(player);
                battleWon();
                onGoingBattle = false;
            }else if(player.HP <= 0){
                player.setHP(0);
                scrollingClear();
                mob.printStats(mob);
                player.printStats(player);
                gameOver("You died.");
                onGoingBattle = false;
            }else {
                battleSystem();
            }
        } else if(choice == 2){
            // check for potions (optional feature)
            scrollingClear();
            player.usedHeal = true;
            player.heal();
            player.setCurrentHP(mob.Attack());
        } else if(choice == 3){
        Run();
        }
    }

    //Here is the logic where the Action of the user is derived from
    public void fightOrFlight(){
        Spacer(2);
        System.out.println("""
                 Will you fight or run away?
                 1: Fight
                 2: Run""");
        int choice = userChoices("->", 2);
        if(choice == 1){
            Actions();
        }else if(choice == 2){
            Run();
        }
    }


    private void Run(){
    int a = ThreadLocalRandom.current().nextInt(1,10);
    if( a <= 3){
        System.out.println("You ran away");
    } else {
        System.out.println("You failed to run");
        Actions();
    }
    }

}
