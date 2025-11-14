package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private final String name;
    private final List<Character> team = new ArrayList<>();


    public Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void addCharacter(Character c)
    {
        team.add(c);
    }
    public List<Character> getTeam() {
        return team;
    }


    public boolean hasAliveCharacters() {
        for (Character c : team)
            if (c.isAlive())
                return true;
        return false;
    }


}
