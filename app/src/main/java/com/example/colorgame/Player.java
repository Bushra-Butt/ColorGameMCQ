package com.example.colorgame;

public class Player {
    int ID;
    String Name;

    public Player(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public Player() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
