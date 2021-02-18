package Swingy.Controller;

import Swingy.Model.Game;
import Swingy.Model.Hero.Hero;
import Swingy.Misc.Saver;
import Swingy.View.Select.SelectHeroView;

public class SelectHeroController {

    private SelectHeroView view;
    private Game game;

    public SelectHeroController(SelectHeroView view) {
        this.view = view;
        game = Game.getInstance();
    }

    public void onSelectButtonPressed(String name) {
        Saver saver = new Saver();
        Hero hero = saver.loadHero(name);
        game.initGame(hero);
        view.openGame();
    }

    public void onCreateButtonPressed() {
        view.openCreateHero();
    }
}