package edu.miracosta.cs112.finalproject.finalproject.Model;

public class BrownTrout extends Fish {

    // Constants
    public static final int APPLY_PRESSURE = 1;
    public static final int GIVE_SLACK = 2;
    public static final int REEL_IN = 3;

    private final boolean isNocturnal;
    private boolean isHiding;

    public BrownTrout(double weight, boolean isNocturnal, boolean isHiding) {
        super("Brown Trout", "Brown trout (Salmo trutta) are medium-sized, cold-water fish with a streamlined body,\n" +
                "brown or golden-brown back, and a pale belly, marked with numerous dark spots,\n" +
                "some with pale halos, and reddish spots on the sides. ", weight);
        this.isNocturnal = isNocturnal;
        this.isHiding = isHiding;

    }

    @Override
    public String fightBehavior() {
        if (Math.random() < 0.6) {
            isHiding = true;
            return "The Brown Trout swims to cover and hides!";
        } else {
            isHiding = false;
            return "The Brown Trout is making a run down stream!";
        }
    }

    @Override
    public boolean isCorrectAction(int playerAction) {
        if (isHiding) {
            return playerAction == APPLY_PRESSURE;
        } else {
            return playerAction == GIVE_SLACK || playerAction == REEL_IN;
        }
    }

    @Override
    public String toString() {
        String nocturnalStatus = isNocturnal ? "Nocturnal" : "Not Nocturnal";

        return super.toString() + "\nStatus: " + nocturnalStatus + " " + isHiding;

    }
}
