package edu.miracosta.cs112.finalproject.finalproject.Model;

/**
 * Thrown when the player tries to select a level
 * that is not yet unlocked.
 */
public class LevelLockedException extends Exception {
    public LevelLockedException(String message) {
        super(message);
    }
}