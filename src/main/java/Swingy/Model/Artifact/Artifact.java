package Swingy.Model.Artifact;

public abstract class Artifact implements java.io.Serializable {

    private int stats;
    protected String name;

    public Artifact(String name, int stats) {
        this.name = name;
        this.stats = stats;
    }

    public int getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }

}