package edu.miracosta.cs112.finalproject.finalproject.Model;

public class GoldenTrout extends Fish {
    // Constants
    public static final int APPLY_PRESSURE = 1;
    public static final int GIVE_SLACK = 2;
    public static final int REEL_IN = 3;

    private boolean isWild;
    private boolean isJumping;

    public GoldenTrout(double weight, boolean isWild) {
        super("Golden Trout", "The California golden trout (Oncorhynchus aguabonita or Oncorhynchus mykiss aguabonita) is a species of trout native to California." + "The golden trout has golden flanks with red, horizontal bands along the lateral lines on each side and about 10 dark, vertical, oval marks (called parr marks) on each side." +
                "In their native habitat, adults range from 6 to 12 inches (15 to 30 cm) long. ", weight);
        this.isWild = isWild;
    }
    public boolean isWild() {
        return isWild;
    }

    @Override
    public String fightBehavior() {
        if (Math.random() < 0.6) {
            isJumping = true;
            return "The Rainbow Trout jumps out of the water glistening in the sun!";
        } else {
            isJumping = false;
            return "The Rainbow Trout is making a run down stream!";
        }
    }
    @Override
    public boolean isCorrectAction(int playerAction) {
        if (isJumping) {
            return playerAction == GIVE_SLACK;
        } else {
            return playerAction == APPLY_PRESSURE || playerAction == REEL_IN;
        }
    }

    @Override
    public String toString() {
        String wildStatus = isWild ? "Wild" : "Stocked";

        return super.toString() + "\nStatus: " + wildStatus + " " + isJumping;

    }
}
