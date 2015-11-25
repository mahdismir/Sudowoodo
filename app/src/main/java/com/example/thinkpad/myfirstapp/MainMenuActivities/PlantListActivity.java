package com.example.thinkpad.myfirstapp.MainMenuActivities;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.example.thinkpad.myfirstapp.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class PlantListActivity extends ListActivity {
    // Declare Variables
    List<String> listOfPlants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);

        //Log.d("TEST", Integer.toString(plantList.size()));
        final ParseUser currentUser = ParseUser.getCurrentUser();
        String username = currentUser.getString("username");
        ParseQuery query = new ParseQuery(username+"_Plants");
        query.whereEqualTo("Owner", username);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(java.util.List<ParseObject> objects,
                             ParseException e) {
                listOfPlants.add(currentUser.getString("username")+"'s plants");
                if (e == null) {
                    Log.d("TEST", "Retrieved " + objects.size() + " owner plants.");
                    for (ParseObject curPlant : objects) {
                        //construct the plant
                        //get the nickname
                        String nickname = (String) curPlant.get("Nickname");
                        String type = (String) curPlant.get("Type");
                        String temp = "Plant: " + nickname + " ---- Type: " + type;
                        Log.d("TEST", "ADDING " + temp);
                        listOfPlants.add(temp);
                        //Log.d("TEST", "Plant List Size: " + Integer.toString(listOfPlants.size()));
                    }
                } else {
                    Log.d("OWNER", "Error: " + e.getMessage());
                }
                Log.d("TEST", "Plant List Size: " + Integer.toString(listOfPlants.size()));
                String[] arr = listOfPlants.toArray(new String[listOfPlants.size()]);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getListView().getContext(),
                        android.R.layout.simple_list_item_1, arr);
                getListView().setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_plant_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
