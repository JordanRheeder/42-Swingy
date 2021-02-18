package Swingy.Model.Hero;


public abstract class HeroFactory {

    public static Hero newHero(String name) {
        switch (name.toUpperCase()) {
            case "THWENN":
                return Director.createWizard(name);
            case "SONYA":
                return Director.createBarbarian(name);
            case "NAZEEBO":
                return Director.createWitchDoctor(name);
            case "KHARAZIM":
                return Director.createMonk(name);
            default:
                throw new IllegalArgumentException("Invalid hero");
        }
    }
}