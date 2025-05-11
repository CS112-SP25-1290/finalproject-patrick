package edu.miracosta.cs112.finalproject.finalproject.Model;

/**
 * Concrete Fish subclass: Rainbow Trout with dynamic behaviors.
 */
public class RainbowTrout extends Fish {
    private final boolean isWild;
    private String currentBehavior;
    private String requiredAction;

    // Behavior types
    private static final String[] BEHAVIORS = {
            "The trout is making a powerful run downstream!",
            "The fish is swimming directly towards you!",
            "The trout jumped high out of the water!",
            "The fish is diving deep!",
            "The trout is shaking its head violently!",
            "The fish is swimming in circles!"
    };

    // Required actions for each behavior
    private static final String[] ACTIONS = {
            "Slack",    // for downstream run
            "Tension",  // for swimming towards
            "Slack",    // for jumping
            "Tension",  // for diving deep
            "Slack",    // for head shaking
            "Tension"   // for swimming in circles
    };

    // Instructions for each behavior
    private static final String[] INSTRUCTIONS = {
            "Give it slack to prevent line break!",
            "Add tension to keep the line tight!",
            "Loosen the line while it's airborne!",
            "Pull up to prevent it from reaching the bottom!",
            "Let it thrash to avoid hook pull-out!",
            "Keep steady pressure to tire it out!"
    };

    public RainbowTrout(double baseWeight, boolean isWild) {
        super("Rainbow Trout",
                "A colorful trout known for its acrobatic fights and pink stripe.",
                baseWeight);
        this.isWild = isWild;
    }

    public boolean isWild() { return isWild; }

    @Override
    public String fightBehavior() {
        int behaviorIndex = random.nextInt(BEHAVIORS.length);
        currentBehavior = BEHAVIORS[behaviorIndex] + "\n" + INSTRUCTIONS[behaviorIndex];
        requiredAction = ACTIONS[behaviorIndex];
        return currentBehavior;
    }

    @Override
    public boolean isCorrectAction(String playerAction) {
        return playerAction.equals(requiredAction);
    }

    public String getRequiredAction() {
        return requiredAction;
    }
}