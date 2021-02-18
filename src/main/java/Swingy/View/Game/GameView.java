package Swingy.View.Game;

import Swingy.Main;
import Swingy.Controller.GameController;
import Swingy.Misc.Coords;
import Swingy.Model.Game;
import Swingy.Model.Hero.Hero;


import java.util.Scanner;

import static Swingy.Misc.OutputMessages.*;

public class GameView {

    private GameController controller;

    public void start() {
        controller = new GameController(this);

        controller.onStart();
    }

    public void update(Game game) {
        GameView view = new GameView();

        PrintMessage("-----------MAP----------");
        view.printMap(game.getMap(), game.getHeroCoord(), game.getHero().getName());
        PrintMessage("----------INFO----------");
        PrintMessage(game.getHero().getName().substring(0,1).toUpperCase() + game.getHero().getName().substring(1).toLowerCase() +"\n" +
               "XP: "+ game.getHero().getExperience() + "\n" +
                "Class: " + game.getHero().getHeroClass() + "\n" +
                "Position: " + "(" + game.getHeroCoord().getX() +
                "," + game.getHeroCoord().getY() + ")");
        PrintMessage("------------------------");

        getUserInput(game.getHero().getName());
    }

    private void getUserInput(String heroName) {
        Scanner scanner = Main.getScanner();

        Directions();
        PrintMessage(ANSI_RED + "Exit" + ANSI_RESET);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("north".equalsIgnoreCase(input)
                || "east".equalsIgnoreCase(input)
                || "south".equalsIgnoreCase(input)
                || "west".equalsIgnoreCase(input)) {
                controller.onMove(input);
                break;
            } else if ("exit".equalsIgnoreCase(input)) {
                QuitMessage(heroName);
                System.exit(1);
            } else {
                Directions();
            }
        }
    }

    public void printMap(boolean[][] map, Coords heroCoord, String heroName) {
        PrintMessage("MAP " + map.length + " " + map.length + '\n');
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (heroCoord.getX() == j && heroCoord.getY() == i) {
                    switch (heroName.toUpperCase()) {
                        case "THWENN":
                            PrintMap(" " + ANSI_PURPLE + heroName.toUpperCase().charAt(0) + ANSI_RESET + " ");
                            break;
                        case "SONYA":
                            PrintMap(" " + ANSI_RED + heroName.toUpperCase().charAt(0) + ANSI_RESET + " ");
                            break;
                        case "KHARAZIM":
                            PrintMap(" " + ANSI_BLUE + heroName.toUpperCase().charAt(0) + ANSI_RESET + " ");
                            break;
                        case "NAZEEBO":
                            PrintMap(" " + ANSI_GREEN + heroName.toUpperCase().charAt(0) + ANSI_RESET + " ");
                            break;
                    }
                }
                else if (map[i][j])
                    PrintMap(ANSI_YELLOW + " D " + ANSI_RESET);
                else
                    PrintMap(ANSI_BLACK + " ■ " + ANSI_RESET);
            }
            PrintMessage(" ");
        }
    }

    public void getVillainCollisionInput() {
        Scanner scanner = Main.getScanner();

        Fight();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("fight".equalsIgnoreCase(input)) {
                controller.onFight();
                break;
            } else if ("run".equalsIgnoreCase(input)) {
                controller.onRun();
                break;
            } else {
                FightCommands();
            }
        }
    }

    public boolean replaceArtifact(String replaceMessage) {
        Scanner scanner = Main.getScanner();

        ReplaceMessage(replaceMessage);
        ReplaceCommands();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if ("leave".equalsIgnoreCase(input)) {
                return false;
            } else if ("replace".equalsIgnoreCase(input)) {
                return true;
            } else {
                ReplaceCommands();
            }
        }
        return false;
    }

}