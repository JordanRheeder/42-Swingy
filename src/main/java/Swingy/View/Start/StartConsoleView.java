package Swingy.View.Start;

import Swingy.Controller.StartController;
import Swingy.Main;
import Swingy.View.*;
import Swingy.View.Create.CreateHeroView;
import Swingy.View.Select.SelectHeroView;
import java.util.Scanner;

import static Swingy.Misc.OutputMessages.*;

public class StartConsoleView {

    private StartController controller;

    public void Start() {
        controller = new StartController(this);
        Scanner scanner = Main.getScanner();
        StartMessage();

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if ("create".equalsIgnoreCase(input)) {
                controller.onCreateHeroButtonPressed();
                break;
            } else if ("select".equalsIgnoreCase(input)) {
                controller.onSelectHeroButtonPressed();
                break;
            } else if ("Exit".equalsIgnoreCase(input)) {

                System.exit(1);
            }
        }
    }

    public void openCreateHero() { new CreateHeroView().start();
    }

    public void openSelectHero() {
        new SelectHeroView().start();
    }
}