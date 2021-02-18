package Swingy;

import Swingy.View.Start.StartConsoleView;
import Swingy.View.Start.StartGuiView;
import static Swingy.Misc.OutputMessages.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;



public class Main {
    private static Scanner scanner;
    private static JFrame frame = getFrame();
    public static void main(String[] args) {
        if (args.length != 1 || (!args[0].equals("gui") && !args[0].equals("console"))) {
            StartError();
            System.exit(1);
        }

        if (args[0].equals("console")) {
            PrintMessage("console");
            new StartConsoleView().Start();
        } else if (args[0].equals("gui")) {
            PrintMessage("gui");
            try {
                new StartGuiView().StartGui();
            } catch (NullPointerException e) {
                System.out.println(e.getLocalizedMessage());
                new StartConsoleView().Start();
            }
        } else {
            System.exit(1);
        }

    }

    public static JFrame getFrame() {
        if (frame == null) {
            frame = new JFrame("Swingy");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frameListener();
        }
        return frame;
    }

    public static void showFrame() {
        if (frame != null)
            frame.setVisible(true);
    }

    public static void hideFrame() {
        if (frame != null)
            frame.setVisible(false);
    }

    public static Scanner getScanner() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner;
    }

    private static void frameListener() {
        getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
    }
}
