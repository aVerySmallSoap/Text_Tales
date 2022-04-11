package com.LirysBoo.Logic;
import java.util.Scanner;

public class UserActions {
    private final Scanner scanner = new Scanner(System.in);

    //Custom toInt Scanner for user choices
    public int userAction(String prompt, int userChoices){
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

    private void Run(){

    }

    private void Fight(){
        GameLogic.battleSystem();
    }

    //Here is the logic where the Action of the user is derived from
    public void fightOrFlight(){
        System.out.println("""
                 Will you fight or run away?
                 1: Fight ; 2: Run""");
        int choice = userAction("->", 2);
        if(choice == 1){
            Fight();
        }else if(choice == 2){
            Run();
        }
    }

}
