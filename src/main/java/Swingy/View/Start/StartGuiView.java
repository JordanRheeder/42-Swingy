package Swingy.View.Start;

import Swingy.Main;

import javax.swing.*;
import javax.validation.constraints.NotNull;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGuiView extends JPanel {
    private JPanel Swingy;
    private JButton start;
    private JButton exit;

    public void StartGui() {
        this.add(start);
        this.add(exit);

        this.setVisible(true);
        Main.getFrame().setContentPane(this);
        Main.getFrame().revalidate();
        Main.showFrame();
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.hideFrame();
                new StartConsoleView().Start();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

}
