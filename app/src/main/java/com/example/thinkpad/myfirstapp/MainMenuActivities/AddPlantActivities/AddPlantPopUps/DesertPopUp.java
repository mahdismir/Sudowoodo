package com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.AddPlantPopUps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.ParseAddPlant;
import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.PlantCategories.AddDesert;
import com.example.thinkpad.myfirstapp.R;

public class DesertPopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert_pop_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));

        Button cancelbutton = (Button) findViewById(R.id.CancelOnPopUpDesert);
        cancelbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddDesert.class);
                finish();

            }
        });

        Button addPlantButton = (Button) findViewById(R.id.AddonPopUpDesert);
        addPlantButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                // Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), ParseAddPlant.class);
                //get the string from
                EditText editNickname = (EditText)findViewById(R.id.plant_nickname);
                String plantNickname = editNickname.getText().toString();
                nextScreen.putExtra("plantNickname", plantNickname);
                nextScreen.putExtra("plantType", "Desert");
                startActivity(nextScreen);
                finish();
            }
        });


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }

}
