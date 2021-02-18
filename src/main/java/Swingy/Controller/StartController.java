package Swingy.Controller;

import Swingy.View.Start.StartConsoleView;

public class StartController {

    private StartConsoleView view;

    public StartController(StartConsoleView view) {
        this.view = view;
    }

    public void onCreateHeroButtonPressed() {
        view.openCreateHero();
    }

    public void onSelectHeroButtonPressed() {
        view.openSelectHero();
    }
}