package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.Model.RainbowTrout;

/**
 * Standalone demo of trout behavior (no GUI).
 */
public class FishingGame {
    public static void main(String[] args) {
        RainbowTrout trout = new RainbowTrout(4.2, true);
        System.out.println("You hooked a " + trout.getSpecies() + "!");
        System.out.println(trout.fightBehavior());

        GameState state = new GameState();
        System.out.println("Starting location: " + state.getLocation());
    }

    /**
     * Inner snapshot of the game state.
     */
    public static class GameState {
        private final String location = "Owens River";
        public String getLocation() { return location; }
    }
}