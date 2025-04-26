package edu.miracosta.cs112.finalproject.finalproject.Model;

import java.util.List;

public abstract class Location {
    private String name, description;
    protected List<Fish> availableFish;
    public String getName()         { return name; }
    public String getDescription()  { return description; }
}
