package Swingy.Controller;

import Swingy.Misc.OutputMessages;
import Swingy.Model.Game;
import Swingy.Model.Artifact.Armour;
import Swingy.Model.Artifact.Artifact;
import Swingy.Model.Artifact.Helm;
import Swingy.Model.Artifact.Weapon;
import Swingy.Model.Hero.Hero;
import Swingy.Model.Hero.Villain;
import Swingy.Misc.Saver;
import Swingy.Misc.Coords;
import Swingy.View.Game.GameView;

import java.util.Random;

import static Swingy.Misc.OutputMessages.PrintMessage;

public class GameController {

    private GameView view;
    private Game game;
    private Coords previousPosition;
    private Saver saver = new Saver();
    public GameController(GameView view) {
        this.view = view;
        game = Game.getInstance();
        previousPosition = new Coords(0, 0);
    }

    public void onStart() {
        view.update(game);
    }

    public void onMove(String direction) {
        int x = game.getHeroCoord().getX();
        int y = game.getHeroCoord().getY();
        previousPosition.setX(x);
        previousPosition.setY(y);
        switch (direction.toUpperCase()) {
            case "NORTH":
                y--;
                break;
            case "EAST":
                x++;
                break;
            case "SOUTH":
                y++;
                break;
            case "WEST":
                x--;
                break;
        }

        if (x < 0 || y < 0 || x >= game.getMapSize() || y >= game.getMapSize()) {
            winGame();
            return;
        }

        game.getHeroCoord().setX(x);
        game.getHeroCoord().setY(y);

        if (game.getMap()[y][x]) {
            villainCollision();
        }

        if (game.getHero().getHitPoints() > 0)
            view.update(game);
    }

    private void winGame() {
        PrintMessage("You win! And got additional " + game.getMapSize() * 100 + "xp!");
        addExperience(game.getMapSize() * 100);
        game.getHeroCoord().setX(game.getMapSize()/2);
        game.getHeroCoord().setY(game.getMapSize()/2);
        PrintMessage(game.getHeroCoord().toString());
//        PrintMessage(game.getHeroCoord().getX());
//        PrintMessage(game.getHeroCoord().getY());
        saver.saveHero(game.getHero());
        game.initGame(game.getHero());
        view.start();
    }

    private void villainCollision() {
        view.getVillainCollisionInput();
    }

    public void onRun() {
        if (new Random().nextBoolean()) {
            PrintMessage("You are lucky! And moved to previous position!");
            game.getHeroCoord().setX(previousPosition.getX());
            game.getHeroCoord().setY(previousPosition.getY());
        } else {
            PrintMessage("You have to fight");
            onFight();
        }
    }

    private void setArtifact(Artifact artifact) {
        if (artifact != null) {
            if (artifact instanceof Weapon) {
                if (game.getHero().getWeapon() == null || view.replaceArtifact("your weapon: " + game.getHero().getWeapon() + ", found: " + artifact)) {
                    game.getHero().equipWeapon((Weapon) artifact);
                    PrintMessage("You equipped new weapon: " + artifact);
                }
            } else if (artifact instanceof Helm) {
                if (game.getHero().getHelm() == null || view.replaceArtifact("your helmet: " + game.getHero().getHelm() + ", found: " + artifact)) {
                    game.getHero().equipHelm((Helm) artifact);
                    PrintMessage("You equipped new helm: " + artifact);
                }
            } else if (artifact instanceof Armour) {
                if (game.getHero().getArmour() == null || view.replaceArtifact("your armour: " + game.getHero().getArmour() + ", found: " + artifact)) {
                    game.getHero().equipArmour((Armour) artifact);
                    PrintMessage("You equipped new armour: " + artifact);
                }
            }
        }
    }

    public void onFight() {
        Villain villain = game.generateVillain();
        int xp = (((game.getHero().getLevel() + 1) * 1000 + game.getHero().getLevel() * game.getHero().getLevel() * 450) / 3);
            PrintMessage("You win, and got " + xp + "xp.");
            addExperience(xp);
            game.getMap()[game.getHeroCoord().getY()][game.getHeroCoord().getX()] = false;
            setArtifact(villain.getArtifact());
    }

    private void addExperience(int addXP) {
        int level = game.getHero().getLevel();
        game.getHero().addExperience(addXP);
        if (level != game.getHero().getLevel())
            PrintMessage("Level UP!\nHP, attack and defense were increased!");
    }

}