package edu.miracosta.cs112.finalproject.finalproject.Model;

import java.util.Random;

/**
 * Abstract base class for all fish in Sierra Trout Quest.
 * Each fish has a species name, description, and randomized weight.
 * Subclasses must implement their own fighting behaviors.
 *
 * @author Patrick Eulmi
 * @version 1.0
 * @since 2025-05-10
 */
public abstract class Fish {
    /** The type of fish */
    private final String species;

    /** Basic info about the fish */
    private final String description;

    /** How much the fish weighs in pounds */
    private double weight;

    /** Used to randomize fish weights */
    protected static final Random random = new Random();

    /**
     * Creates a new fish with randomized weight.
     * The weight varies by ±50% from the base weight.
     *
     * @param species the type of fish
     * @param description info about the fish
     * @param baseWeight starting weight before randomization
     */
    protected Fish(String species, String description, double baseWeight) {
        this.species = species;
        this.description = description;

        // Randomize weight: baseWeight ± 50%
        this.weight = baseWeight + (random.nextDouble() - 0.5) * baseWeight;
        // Make sure fish weighs at least 0.5 lbs
        this.weight = Math.max(0.5, this.weight);
    }

    /**
     * Gets the fish species.
     * @return the species name
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets the fish description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the fish weight.
     * @return weight in pounds
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the fish weight.
     * @param weight new weight in pounds
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets what the fish is doing during the fight.
     * Each type of fish has different behaviors.
     *
     * @return text describing the fish's action
     */
    public abstract String fightBehavior();

    /**
     * Checks if the player made the right choice.
     *
     * @param playerAction what the player chose ("Slack" or "Tension")
     * @return true if correct, false if wrong
     */
    public abstract boolean isCorrectAction(String playerAction);

    /**
     * Shows fish info in a nice format.
     * @return formatted string with species, weight, and description
     */
    @Override
    public String toString() {
        return species + " (" + String.format("%.1f", weight) + " lbs)\n" + description;
    }
}
