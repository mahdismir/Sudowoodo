package com.example.thinkpad.myfirstapp.data;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * Created by mitch_000 on 11/22/2015.
 */
public class Person {
    List<String> listOfPlants = new ArrayList<>();
    ArrayList<Plant> plantList;
    String username;

    public Person() {
        plantList = new ArrayList<>();
        ParseUser currentUser = ParseUser.getCurrentUser();
        this.username = currentUser.getString("username");
    }

    public String getUsername() {
        return username;
    }
    public List<String> getPlantList() {

        return getPlantsFromParse();
    }

    public List<String> getPlantsFromParse() {

        //Log.d("TEST", "getPlantsFromParse started!");
        ParseQuery query = new ParseQuery(username+"_Plants");
        query.whereEqualTo("Owner", username);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(java.util.List<ParseObject> objects,
                             ParseException e) {
                if (e == null) {
                    //Log.d("TEST", "Retrieved " + objects.size() + " owner plants.");
                    for (ParseObject curPlant : objects) {
                        //construct the plant
                        //get the nickname
                        String nickname = (String) curPlant.get("Nickname");
                        String type = (String) curPlant.get("Type");
                        String temp = "Plant: " + nickname + " ---- Type: " + type;
                        listOfPlants.add(temp);
                        plantList.add(new Plant(nickname, type));
                        //get the type

                        //push it to the plant list.
                        //test if you actually got it
                    }
                    int counter = 0;

                } else {
                    Log.d("OWNER", "Error: " + e.getMessage());
                }


            }
        });
        Log.d("TEST", "Adding: " + Integer.toString(listOfPlants.size()) + " plants.");
        for (Plant plant : plantList ) {
            String temp = "Plant: " + plant.getNickname() + " ---- Type: " + plant.getType();



        }
        //build each plant individually, push them into plantlist
        //do stuff with the plants.
        //Log.d("TEST", "Returning: "+Integer.toString(listOfPlants.size())+" plants.");
        return listOfPlants;
    }

    public void setUsername(String username) {
        ParseUser currentUser = ParseUser.getCurrentUser();
        this.username = currentUser.getString("username");
    }



    // Reconstruct all plants on Parse
    public void retrievePlants(){
        //get the # of plants associated with this user
        //call reconstruct for each plant

    }
    //void handleDaily();
    //void addPlant(Plant plant) // use the explicit constructor
    //void removePlant(String nickname);
    //void waterPlant(String nickname);public String getOwner() { return owner;}    public String getOwner() {
         //return owner;
    //}

}
