package Swingy.Model.Hero;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public abstract class Character implements java.io.Serializable {

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 16, message = "Name length cannot be less than 2 or greater than 16")
    protected String name;

    @Min(value = 0, message = "Attack cannot be less than 0")
    protected int attack;

    @Min(value = 0, message = "Defense cannot be less than 0")
    protected int defense;

    @Min(value = 1, message = "Hit points cannot be less than 1")
    protected int hitPoints;

    public Character(String name, int attack, int defense, int hitPoints) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}