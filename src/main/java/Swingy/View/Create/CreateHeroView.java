package Swingy.View.Create;

import Swingy.Main;
import Swingy.Controller.HeroController;
import Swingy.View.Game.GameView;
import static Swingy.Misc.OutputMessages.*;


import java.util.Scanner;

public class CreateHeroView {

    private HeroController controller;

    public void start() {
        controller = new HeroController(this);

        getUserInput();
    }

//    @Override
    public void getUserInput() {
        Scanner scanner = Main.getScanner();
        CreateHero();
        String name = scanner.nextLine();
        controller.onCreateButtonPressed(name);
    }

//    @Override
    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

//    @Override
    public void openGame() {
        new GameView().start();
    }
}