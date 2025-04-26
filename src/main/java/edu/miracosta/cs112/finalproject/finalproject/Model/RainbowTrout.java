package edu.miracosta.cs112.finalproject.finalproject.Model;

public class RainbowTrout extends Fish {

    // Constants
    public static final int APPLY_PRESSURE = 1;
    public static final int GIVE_SLACK = 2;
    public static final int REEL_IN = 3;

    private boolean isWild;
    private boolean isJumping;


    /**
     * Full constructor for RainbowTrout
     * @param weight
     * @param isWild Whether trout is wild or stocked
     */
    public RainbowTrout(double weight, boolean isWild) {
        super("Rainbow Trout","A colorful trout known for its pink/red band along the sides.\nThey are " +
                "strong fighters and often jump when hooked.\nNative to the Pacific coast " +
                "but widely introduced throughout North American\n", weight);
        this.isWild = isWild;
        this.isJumping = false;



    }

    public boolean isJumping() {
        return isJumping;
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
