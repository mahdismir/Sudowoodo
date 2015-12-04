package com.example.thinkpad.myfirstapp.data;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class Person {
    List<String> listOfPlants = new ArrayList<>();
    ArrayList<Plant> plantList;
    String username;

    // Constructor
    public Person() {
        plantList = new ArrayList<>();
        ParseUser currentUser = ParseUser.getCurrentUser();
        this.username = currentUser.getString("username");
    }


    // Accessor Methods
    public String getUsername() {
        return username;
    }


    public List<String> getPlantList() { return getPlantsFromParse(); }


    // Setting the username.
    public void setUsername(String username) {
        ParseUser currentUser = ParseUser.getCurrentUser();
        this.username = currentUser.getString("username");
    }


    // Query data from Parse.
    public List<String> getPlantsFromParse() {

        ParseQuery query = new ParseQuery(username+"_Plants");
        query.whereEqualTo("Owner", username);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(java.util.List<ParseObject> objects,
                             ParseException e) {
                if (e == null) {

                    // Construct the plants from the database and store them in an ArrayList.
                    for (ParseObject curPlant : objects) {
                        String nickname = (String) curPlant.get("Nickname");
                        String type = (String) curPlant.get("Type");
                        String temp = "Plant: " + nickname + " ---- Type: " + type;
                        listOfPlants.add(temp);
                        plantList.add(new Plant(nickname, type));
                    }
                    int counter = 0;
                }
                else {
                    Log.d("OWNER", "Error: " + e.getMessage());
                }
            }
        });

        Log.d("TEST", "Adding: " + Integer.toString(listOfPlants.size()) + " plants.");
        for (Plant plant : plantList ) {
            String temp = "Plant: " + plant.getNickname() + " ---- Type: " + plant.getType();
        }

        return listOfPlants;
    }
}
