package Swingy.Misc;

import Swingy.Model.Hero.Hero;

import java.io.*;
import java.util.Scanner;

import static Swingy.Misc.OutputMessages.PrintMessage;

public class Saver {
    Scanner scanner = new Scanner(System.in);

    public static void Saver() {
        File directory = new File("heroes/");
        if (!directory.exists())
            directory.mkdir();
    }

    public static void Printdata(Hero object1)
    {
        PrintMessage("Name: " + object1.getName()+ " "
                + "Hero: " + object1.getHeroClass()+ " "
                + "Weapon: " + object1.getWeapon() + " "
                + "Armour: " + object1.getArmour()+ " "
                + "Level: " + object1.getLevel()+ " "
                + "Experience: " + object1.getExperience());
    }

    public void saveHero(Hero hero) {
        File saveFile = new File("heroes/" + hero.getName() + ".txt");
        try {
            FileOutputStream file = new FileOutputStream(saveFile);
            ObjectOutputStream fileOut = new ObjectOutputStream(file);
            fileOut.writeObject(hero);
            fileOut.close();
            file.close();
            Printdata(hero);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Hero loadHero(String heroName) {
        File saveFile = new File("heroes/" + heroName + ".txt");
        if (!saveFile.exists()) {
            PrintMessage("Hero save file not found!");
            return null;
        }
        Hero hero;
        try {
            FileInputStream file = new FileInputStream(saveFile);
            ObjectInputStream in  = new ObjectInputStream(file);

            hero = (Hero)in.readObject();
            in.close();
            file.close();
            PrintMessage("Save file loaded!");
            return hero;
        } catch (IOException i) {
            PrintMessage(i.toString());
            return null;
        } catch (ClassNotFoundException c) {
            PrintMessage("Hero class not found.\n" + c);
            return null;
        }
    }

//    public void deleteHero(String heroName) {
//        File saveFile = new File("heroes\\" + heroName + ".name.txt");
//        String path = saveFile.getAbsolutePath();
//        if (saveFile.delete()) {
//
//            String line = scanner.nextLine();
//        } else{
//            // System.out.println(path + " couldn't be deleted.");
//            // System.out.println("Press any key to continue.");
//            String line = scanner.nextLine();
//        }
//    }
}
