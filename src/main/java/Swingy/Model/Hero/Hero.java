package Swingy.Model.Hero;

import Swingy.Model.Artifact.Armour;
import Swingy.Model.Artifact.Helm;
import Swingy.Model.Artifact.Weapon;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Hero extends Character implements java.io.Serializable {

    private Weapon weapon;
    private Armour armour;
    private Helm helm;

    @Min(value = 0, message = "Level should not be less than 0")
    private int level;

    @Min(value = 0, message = "Experience should not be less than 0")
    private int experience;

    @NotNull(message = "Hero class cannot be null")
    private String heroClass;



    public Hero(String name, int attack, int defense, int hitPoints, String heroClass,
                int level, int experience, Weapon weapon, Armour armour, Helm helm) {
        super(name, attack, defense, hitPoints);
        this.weapon = weapon;
        this.armour = armour;
        this.helm = helm;
        this.level = level;
        this.experience = experience;
        this.heroClass = heroClass;
    }

    public void equipWeapon(Weapon weapon) {
        if (this.weapon != null) {
            this.attack -= this.weapon.getStats();
        }
        this.attack += weapon.getStats();
        this.weapon = weapon;
    }

    public void equipHelm(Helm helm) {
        if (this.helm != null) {
            this.hitPoints -= this.helm.getStats();
            if (this.hitPoints + helm.getStats() <= 0) {
                this.hitPoints += this.helm.getStats();
                return;
            }
        }
        this.hitPoints += helm.getStats();
        this.helm = helm;
    }

    public void equipArmour(Armour armour) {
        if (this.armour != null) {
            this.defense -= this.armour.getStats();
        }
        this.defense += armour.getStats();
        this.armour = armour;
    }

    public void addExperience(int addXP) {
        int ding = (level + 1) * 1000 + level * level * 450;

        if (experience + addXP >= ding)
            levelUp();
        experience += addXP;
    }

    private void levelUp() {
        level++;
        hitPoints += 50 + level * 10;
        attack += level * 3;
        defense += level * 2;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public Helm getHelm() {
        return helm;
    }

    public void setHelm(Helm helm) {
        this.helm = helm;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public String getHeroClass() { return heroClass; }
}