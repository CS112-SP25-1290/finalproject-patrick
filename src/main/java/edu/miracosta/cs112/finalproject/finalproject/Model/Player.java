package edu.miracosta.cs112.finalproject.finalproject.Model;

import java.util.*;

public class Player {
    private String name;
    private List<Fish> caughtFish = new ArrayList<>();
    private Inventory inventory = new Inventory();
    public void catchFish(Fish f) { caughtFish.add(f); }
    // … getters/setters …
}
