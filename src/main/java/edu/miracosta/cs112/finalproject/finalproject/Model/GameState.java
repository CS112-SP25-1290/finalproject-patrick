package edu.miracosta.cs112.finalproject.finalproject.Model;

/**
 * Tracks the overall game state including level progression
 */
public class GameState {
    private static GameState instance = new GameState();

    private boolean[] levelsCompleted = new boolean[3];
    private int currentLevel = 0;
    private String currentLocation = "Silver Creek";

    private GameState() {
        // Private constructor for singleton
    }

    public static GameState getInstance() {
        return instance;
    }

    public boolean isLevelUnlocked(int level) {
        if (level == 1) return true; // First level always unlocked
        return level > 0 && level <= levelsCompleted.length && levelsCompleted[level - 2];
    }

    public void completeLevel(int level) {
        if (level > 0 && level <= levelsCompleted.length) {
            levelsCompleted[level - 1] = true;
        }
    }

    public void setCurrentLevel(int level) {
        this.currentLevel = level;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public String getLocation() {
        return switch (currentLevel) {
            case 1 -> "Owens River";
            case 2 -> "Silver Creek";
            case 3 -> "Hot Creek";
            default -> "Silver Creek";
        };
    }
}