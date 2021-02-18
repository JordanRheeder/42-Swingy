package Swingy.Controller;

import Swingy.Model.Game;
import Swingy.Model.Hero.Hero;
import Swingy.Model.Hero.HeroFactory;
import Swingy.View.Create.CreateHeroView;

import static Swingy.Misc.OutputMessages.PrintMessage;

public class HeroController {

    private CreateHeroView view;
    private Game game;

    public HeroController(CreateHeroView view) {
        this.view = view;
        game = Game.getInstance();
    }

    public void onCreateButtonPressed(String name) {
        Hero hero;
        try {
            hero = HeroFactory.newHero(name);
        } catch (IllegalArgumentException  e) {
            PrintMessage(e.getMessage());
            view.getUserInput();
            return;
        }
        game.initGame(hero);
        view.openGame();
    }
}