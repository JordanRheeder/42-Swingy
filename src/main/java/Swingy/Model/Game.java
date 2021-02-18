package Swingy.Model;

import Swingy.Model.Artifact.Armour;
import Swingy.Model.Artifact.Artifact;
import Swingy.Model.Artifact.Helm;
import Swingy.Model.Artifact.Weapon;
import Swingy.Model.Hero.Character;
import Swingy.Model.Hero.Hero;
import Swingy.Model.Hero.Villain;
import Swingy.Misc.Coords;
import Swingy.Misc.Saver;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private static Game instance = null;

    private Hero hero;
    private Coords heroCoord;
    private int mapSize;
    private boolean[][] map;

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void initGame(Hero hero) {
        this.hero = hero;
        Saver saver = new Saver();
        //mkdir
        saver.Saver();
        saver.saveHero(hero);
        generateMap();
        generateVillains();
        putHero();
    }

    private void generateMap() {
        int level = hero.getLevel();
        mapSize = (level - 1) * 5 + 10 - (level % 2);
        map = new boolean[mapSize][mapSize];
    }

    private void generateVillains() {
        int rand;
        int level = hero.getLevel();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                rand = ThreadLocalRandom.current().nextInt(0, 100);
                if ((level + 1) * 10 >= rand)
                    map[i][j] = true;
            }
        }
    }

    public Villain generateVillain() {
        int attack = ThreadLocalRandom.current().nextInt(hero.getAttack() - 12, hero.getAttack() + 7 + hero.getLevel());
        int defense = ThreadLocalRandom.current().nextInt(hero.getDefense() - 12, hero.getDefense() + 9 + hero.getLevel());
        int hitPoints = ThreadLocalRandom.current().nextInt(hero.getHitPoints() - 35, hero.getHitPoints() + 55 + hero.getLevel());

        Artifact artifact = generateArtifact();
        return new Villain("Villain", attack, defense, hitPoints, artifact);
    }

    private Artifact generateArtifact() {
        // 30%
        int rand = ThreadLocalRandom.current().nextInt(0, 10);

        Artifact artifact = null;
        if (rand == 0)
            artifact = new Weapon("Sword of a Thousand Truths", ThreadLocalRandom.current().nextInt(1, 5 * (hero.getLevel() + 1)));
        else if (rand == 1)
            artifact = new Helm("Deadmau5 Helmet", ThreadLocalRandom.current().nextInt(1, 3 * (hero.getLevel() + 1)));
        else if (rand == 2)
            artifact = new Armour("Bulwark of Azzinoth", ThreadLocalRandom.current().nextInt(1, 4 * (hero.getLevel() + 1)));
        return artifact;
    }



    private void putHero() {
        heroCoord = new Coords(mapSize / 2, mapSize / 2);
        map[heroCoord.getY()][heroCoord.getX()] = false;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Coords getHeroCoord() {
        return heroCoord;
    }

    public void setHeroCoord(Coords heroCoord) {
        this.heroCoord = heroCoord;
    }

    public boolean[][] getMap() {
        return map;
    }

    public void setMap(boolean[][] map) {
        this.map = map;
    }
}