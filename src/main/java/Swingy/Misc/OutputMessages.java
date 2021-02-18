package Swingy.Misc;

import Swingy.Model.Hero.Director;

import java.io.File;
import static Swingy.Misc.Saver.*;

public class OutputMessages {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLACK = "\u001b[30m";

    public static void PrintMessage(String Message) {
        System.out.println(Message);
    }

    public static void PrintMap(String Message) {
        System.out.print(Message);
    }

    public static void StartError() {
        PrintMessage("Please enter 'gui' or 'console' to StartGui Swingy.");
    }

    public static void Commands() {
        PrintMessage("You may use the following commands:\n" +
                ANSI_GREEN + "Create\n" +
                "Select\n" +
                ANSI_RED + "Exit" + ANSI_RESET);
    }

    public static void StartMessage() {
        PrintMessage(ANSI_RED + "Welcome to Swingy!" + ANSI_RESET);
        Commands();
    }

    public static void WrongInput() {
        PrintMessage("Incorrect input!");
        Commands();
    }

    public static void CreateHero() {
        PrintMessage("Pick a Hero by entering their name.\n" +
                ANSI_PURPLE + "Thwenn - Wizard\n" +
                ANSI_RED + "Sonya - Barbarian\n" +
                ANSI_GREEN +"Nazeebo - Witch Doctor\n" +
                ANSI_BLUE + "Kharazim - Monk\n" + ANSI_RESET);
    }

    public static void Directions() {
        PrintMessage("To move one cell type " +
                ANSI_GREEN + "'NORTH', 'EAST', 'SOUTH', 'WEST'" + ANSI_RESET);
    }

    public static void QuitMessage(String heroName) {
        switch (heroName.toUpperCase()) {
            case "THWENN":
                PrintMessage("Farewell " + ANSI_PURPLE + heroName + ANSI_RESET);
                break;
            case "SONYA":
                PrintMessage("Farewell " + ANSI_RED + heroName + ANSI_RESET);
                break;
            case "NAZEEBO":
                PrintMessage("Farewell " + ANSI_GREEN + heroName + ANSI_RESET);
                break;
            case "KHARAZIM":
                PrintMessage("Farewell " + ANSI_BLUE + heroName + ANSI_RESET);
                break;
        }
    }

    public static void Fight() {
        PrintMessage("You have encountered a monster!\n" +
                "What will you do!?\n" +
                ANSI_GREEN + "'Fight' " + ANSI_RESET + "or" + ANSI_GREEN + " 'Run'" + ANSI_RESET);
    }

    public static void FightCommands() {
        PrintMessage("Enter" + ANSI_GREEN + "'Fight'" + ANSI_RESET + " or " + ANSI_GREEN + "'Run'"  + ANSI_RESET);
    }

    public static void ReplaceCommands() {
        PrintMessage(ANSI_GREEN + "'Replace'" + ANSI_RESET +  " or " + ANSI_GREEN + "'Leave'" + ANSI_RESET);
    }

    public static void ReplaceMessage(String replaceMessage) {
        PrintMessage("Do you want to replace your artifact " + replaceMessage);

    }

    public static void GetFiles() {
        try {
            Saver();
        } catch (Exception e) {
            PrintMessage(e.getMessage() + "\nTry again?");
            System.exit(1);
        }
        File file = new File("/home/jordan/Desktop/deadline/tbag/heroes");
        File[] files = file.listFiles();
        for (File f:files)
        {
            System.out.println(f.getName());
        }

    }

}
