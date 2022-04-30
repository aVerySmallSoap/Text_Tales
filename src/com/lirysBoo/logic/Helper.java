package com.lirysBoo.logic;

import static com.lirysBoo.logic.GameLogic.scanner;

/**
 * The {@code Helper} is a class that holds many QoL functions
 */
public class Helper {

    //Creates 50 whitespaces to create the illusions of clearing the terminal
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
    public static void Skipper(){
        scrollingClear();
        Header("Blank");
        enterAnythingToContinue();
    }

}
