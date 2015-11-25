package com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.PlantCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.AddPlantPopUps.TropicalPopUp;
import com.example.thinkpad.myfirstapp.R;

public class AddTropical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tropical);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button popup = (Button) findViewById(R.id.addTropicalPopUp);
        popup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), TropicalPopUp.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

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
