package com.example.thinkpad.myfirstapp;

import com.parse.ParseObject;

/**
 * Created by Mitch & Vince on 11/21/2015.
 */
public class Plant {
    int lastWatered;
    String type;
    String nickname;
    final int wateringInterval; // This is like the threshold we will use.


    // This is our plant constructor that will initialize the instance variables.
    public Plant(int lastWatered, String type, int wateringInterval, String nickname) {
        this.lastWatered = lastWatered;
        this.type = type;
        this.wateringInterval = wateringInterval;
        this.nickname = nickname;
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
    public int getLastWatered() { return lastWatered; }
    public String getType() {
        return type;
    }
    public int getWateringInterval() {
        return wateringInterval;
    }
    public String getNickname() {
        return nickname;
    }


    /******************************
     * ******* I THINK THIS VIOLATES SRP BECAUSE A PLANT DOESNT UPLOAD ITSELF, PEOPLE DO?
     * *******************************
     */

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
