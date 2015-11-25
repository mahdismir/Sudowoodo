package com.example.thinkpad.myfirstapp.data;

import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by Mitch & Vince on 11/21/2015.
 */
public class Plant {
    int lastWatered;
    String type;
    String nickname;
    String owner;
    final int wateringInterval; // This is like the threshold we will use.

    public Plant(String nickname, String type) {
        this.nickname = nickname;
        this.type = type;
        this.lastWatered = 3;
        this.wateringInterval = 3;

        ParseUser currentUser = ParseUser.getCurrentUser();
        this.owner = currentUser.getString("username");
    }

    public Plant(int wateringInterval, int lastWatered, String type, String nickname, String owner) {
        this.wateringInterval = wateringInterval;
        this.lastWatered = lastWatered;
        this.type = type;
        this.nickname = nickname;

        //Assign the current user to this plant
        ParseUser currentUser = ParseUser.getCurrentUser();
        this.owner = currentUser.getString("username");
    }

    // Setter and Getter Methods
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


    // Creating a function that allows a plant to be uploaded to Parse.
    public void uploadPlant(){

        /* Plant to be uploaded (could we use .this?)
        Plant plant = new Plant(getLastWatered(), getType(), getWateringInterval(),
                                         getNickname());
        */


        //Creating the Parse Object that will be the plant that will upload to Parse.com
        ParseObject uploadingPlant = new ParseObject("uploadedPlants");
        uploadingPlant.put("Nickname",this.getType());
        uploadingPlant.put("Type",this.getType());
        uploadingPlant.put("Owner", this.getOwner());
        uploadingPlant.put("WateringInterval",this.getWateringInterval());
        uploadingPlant.put("LastWatered",this.getLastWatered());
        uploadingPlant.saveInBackground(); // Saves this obj to the server in the background thread.



        /* TESTING CODE...THIS WORKED
        Plant newPlant = new Plant(3, "cactus", 3, "vince");
        ParseObject testPlant = new ParseObject("testPlantTag");
        testPlant.put("Nickname", newPlant.getNickname());
        testPlant.put("Type", newPlant.getType());
        testPlant.put("wateringInterval", newPlant.getWateringInterval());
        testPlant.put("lastWatered", newPlant.getLastWatered());
        testPlant.saveInBackground(); */
    }


    // This function will give you a number of how many days you have left to water your plant.
    // Pre-condition: lastWatered is always less than or equal to wateringInterval.
    // if we return -1, we are greater than the threshold, don't want to inform the user that they
    // have -5 days left to water, we want to tell them it's overdue or something.
    public int numberOfDaysLeftToWater(){
        if(this.getLastWatered() <= this.getWateringInterval())
            return this.getWateringInterval() - this.getLastWatered();
        else{
            return -1; // WE HAVE TO DO SOMETHING WITH THIS IN NOTIFICATIONS!!!!
        }
    }


    // Function will increment the lastWatered interval (this is our counter)
    public void incrementDaily() {
            lastWatered++;
    }

    // Resets the lastWatered count to 0. This is suppose to happen after a person waters a plant.
    public void reset(){
        lastWatered = 0;
    }
}
