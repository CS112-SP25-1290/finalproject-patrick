package edu.miracosta.cs112.finalproject.finalproject;
/**
 * Abstract class representing a fish in Sierra Trout Quest.
 *
 * Fish (abstract)
 *
 * Fish:
 * -species: String
 * -description: String
 * -weight: double
 * #Fish(species: String, description: String, weight: double)
 * +getSpecies(): String
 * +getDescription(): String
 * +getWeight(): double
 * +setWeight(weight: double): void
 * +toString(): String
 * +fightBehavior(): String [abstract]
 * +isCorrectAction(playerAction: int): boolean [abstract]
 *
 * RainbowTrout:
 * -boolean isWild
 * -boolean isJumping
 * +RainbowTrout(double weight, boolean isWild)
 * +isWild(): boolean
 * +isJumping(): boolean
 * +performJump(): void
 * +fightBehavior(): String
 * +isCorrectAction(int playerAction): boolean
 * +toString(): String
 *
 */
public abstract class Fish {
// Instance variables
    private double weight = 0;
    private String species  = null;
    private String description = null;


    /**
     * Constructor that creates a fish
     * @param species the species name of the fish
     * @param description the description of the fish species
     * @param weight the weight of the fish in pounds
     */
    protected Fish(String species, String description, double weight) {
        this.species = species;
        this.description = description;
        this.weight = weight;
    }

    /**
     * Get species name
     * @return Fish species
     */
    public String getSpecies(){
        return species;
    }

    /**
     * Set the weight of the fish
     * @param weight The new weight
     */
    public void setWeight(double weight){
        this.weight = weight;
    }
    /**
     * Get the weight of the fish
     * @return The weight in pounds
     */
    public double getWeight(){
        return weight;
    }
    /**
     * Get the species description
     * @return species description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Determine fish behavior during a fight
     * Each fish will have a different fight style
     * @return String description of the fish's fight style
     */
    public abstract String fightBehavior();

    /**
     * Determine if the correct action is taken during the fight
     * @param playerAction The action taken by the player
     * @return True if the action is correct for the fish behavior
     */
    public abstract boolean isCorrectAction(int playerAction);

    @Override
    public String toString() {
        return species + "(" + weight + " lbs) \n" + description;
    }

}
