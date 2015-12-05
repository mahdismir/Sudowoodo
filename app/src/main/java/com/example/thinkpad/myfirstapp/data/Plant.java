package com.example.thinkpad.myfirstapp.data;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class Plant {
    int lastWatered;
    String type;
    String nickname;
    String owner;
    final int wateringInterval; // This is the threshold we will use.

    public Plant(String nickname, String type) {
        this.nickname = nickname;
        this.type = type;
        this.lastWatered = 3;
        this.wateringInterval = 3;

        ParseUser currentUser = ParseUser.getCurrentUser();
        this.owner = currentUser.getString("username");
    }

    // Constructor that initializes the instance variables.
    public Plant(int wateringInterval, int lastWatered, String type, String nickname, String owner) {
        this.wateringInterval = wateringInterval;
        this.lastWatered = lastWatered;
        this.type = type;
        this.nickname = nickname;

        // Assign the current user to this plant.
        ParseUser currentUser = ParseUser.getCurrentUser();
        this.owner = currentUser.getString("username");
    }

    // Setter and Getter Methods.
    public void setLastWatered(int lastWatered) {
        this.lastWatered = lastWatered;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setOwner(String owner){ this.owner = owner; }
    public int getLastWatered() { return lastWatered; }
    public String getType() { return type; }
    public int getWateringInterval() {
        return wateringInterval;
    }
    public String getNickname() {
        return nickname;
    }
    public String getOwner() { return owner;}
}