package Swingy.Model.Hero;

import Swingy.Misc.Saver;

public class Director {
    private static Saver sf = new Saver();

    private static HeroBuilder buildNew(String name) {
        HeroBuilder builder = new HeroBuilder();
        builder.setName(name);
        builder.setLevel(1);
        builder.setExperience(0);
        builder.setAttack(25);
        builder.setDefense(20);
        builder.setHitPoints(100);
        return builder;
    }

    public static Hero createWizard(String name) {
        HeroBuilder builder = buildNew(name);
        builder.setHeroClass("Wizard");
        try {
            sf.saveHero(builder.getHero());
        } finally {
            return builder.getHero();
        }
    }
    public static Hero createBarbarian(String name) {
        HeroBuilder builder = buildNew(name);
        builder.setHeroClass("Barbarian");
        try {
            sf.saveHero(builder.getHero());
        } finally {
            return builder.getHero();
        }
    }

    public static Hero createWitchDoctor(String name) {
        HeroBuilder builder = buildNew(name);
        builder.setHeroClass("Witch Doctor");
        try {
            sf.saveHero(builder.getHero());
        } finally {
            return builder.getHero();
        }
    }
    public static Hero createMonk(String name) {
        HeroBuilder builder = buildNew(name);
        builder.setHeroClass("Monk");
        try {
            sf.saveHero(builder.getHero());
        } finally {
            return builder.getHero();
        }
    }

}