package Swingy.View.Select;

import Swingy.Main;
import Swingy.Controller.SelectHeroController;
import Swingy.View.Create.CreateHeroView;
import Swingy.View.Game.GameView;
import Swingy.View.Select.SelectHeroView;

import java.io.IOError;
import java.util.Scanner;

import static Swingy.Misc.OutputMessages.GetFiles;

public class SelectHeroView {

    private SelectHeroController controller;
    private int lastIdx = -1;

    public void start() {
        controller = new SelectHeroController(this);

        getInput();
    }

    private void getInput() {
        Scanner scanner = Main.getScanner();
        GetFiles();
        System.out.println("Please enter your characters name");
        while (scanner.hasNext()) {
//            String input = scanner.nextLine();

//            if ("create".equalsIgnoreCase(input)) {
//                controller.onCreateButtonPressed();
//                break;
//            } else if ("select".equalsIgnoreCase(input)) {
            try {
                String name = scanner.nextLine();
                controller.onSelectButtonPressed(name);
                break;
            } catch (IOError e) {
                System.out.println("Unknown command");
            }
        }
    }

    private boolean isValidNumericString(String str, int max) {
        try {
            int n = Integer.parseInt(str);
            if (n <= 0 || n > max)
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void printHeroes(String[] heroes) {
        if (heroes.length == 0)
            System.out.println("No saved heroes");
        for (String hero : heroes) {
            System.out.println(hero);
        }
    }

    //    @Override
    public void updateInfo(String info) {
        System.out.println(info);
    }

    //    @Override
    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
        getInput();
    }

    //    @Override
    public void openGame() {
        new GameView().start();
    }

    //    @Override
    public void openCreateHero() {
        new CreateHeroView().start();
    }
}