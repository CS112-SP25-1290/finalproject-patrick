package edu.miracosta.cs112.finalproject.finalproject.Model;

import java.util.*;

public class Game {
    private static final Game instance = new Game();
    private Player player = new Player();
    private Map<String, Location> locations = new HashMap<>();
    private Game() { /* setup map */ }
    public static Game getInstance() { return instance; }
    public Player getPlayer()        { return player; }
}
