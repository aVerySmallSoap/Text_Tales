package Lirys.logic;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static Lirys.logic.GameLogic.*;

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

    //Here is the logic where the Action of the user is derived from
    public void fightOrFlight(){
        Helper.Spacer(2);
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

    //Allows the player to run
    private void Run(){
        int a = ThreadLocalRandom.current().nextInt(1,10);
        if( a <= 3){
            System.out.println("You ran away");
        } else {
            System.out.println("You failed to run");
            Actions();
        }
    }

    // The logic method where the players actions are handled
    public void Actions(){
        Helper.Spacer(3);
        System.out.println("""
                What will you do?
                1. Attack
                2. Heal
                3. Items
                4. Run
                """);
        int choice = userChoices("->", 4);
        if(choice == 1){
            mob.dealDamageToCurrentHP(player.getAttack());
            player.dealDamageToCurrentHP(mob.getAttack());
            if(mob.getHP() <= 0){
                mob.setHP(0);
                Helper.scrollingClear();
                mob.getStats();
                player.getStats();
                battleWon();
                onGoingBattle = false;
            }else if(player.getHP() <= 0){
                player.setHP(0);
                Helper.scrollingClear();
                mob.getStats();
                player.getStats();
                gameOver("You died.");
                isGameRunning = false;
                onGoingBattle = false;
            }else {
                battleSystem();
            }
        } else if(choice == 2){
            currentSelectedItem = consumables.getItem("Lirys:Healing_Potion");
            if (currentSelectedItem.getITEM_STRING_TAG().equals("Lirys:Healing_Potion") && currentSelectedItem.getItemCount() != 0 ){
                currentSelectedItem.removeItemCount(1);
                Helper.scrollingClear();
                player.usedHeal = true;
                player.heal();
                player.dealDamageToCurrentHP(mob.getAttack());
                battleSystem();
            } else {
                System.out.println("You ran out of " + currentSelectedItem.getItemName());
                Helper.enterAnythingToContinue();
                battleSystem();
            }
        } else if(choice == 3){
            Helper.Separator(5);
            currentSelectedItem.getItemsFromPlayerInventory();
            Actions();
        }else if(choice == 4){
        Run();
        }
    }

}
