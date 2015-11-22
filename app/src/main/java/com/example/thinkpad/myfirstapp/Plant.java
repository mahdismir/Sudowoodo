package com.example.thinkpad.myfirstapp;
/**
 * Created by mitch_000 on 11/21/2015.
 */
public class Plant {
    int lastWatered;
    String type;
    final int wateringInterval; //this is like the threshold
    String nickname;

    public Plant(int lastWatered, String type, int wateringInterval, String nickname) {
        this.lastWatered = lastWatered;
        this.type = type;
        this.wateringInterval = wateringInterval;
        this.nickname = nickname;
    }

    public void setLastWatered(int lastWatered) {
        this.lastWatered = lastWatered;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLastWatered() {

        return lastWatered;
    }

    public String getType() {
        return type;
    }

    public int getWateringInterval() {
        return wateringInterval;
    }

    public String getNickname() {
        return nickname;
    }

//int needsToBeWateredToday()
    //void incrementDaily() // ++ increment per day
    //void reset() // reset after we water (sets back to 0)
}
