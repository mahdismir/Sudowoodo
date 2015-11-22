package com.example.thinkpad.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.thinkpad.myfirstapp.test.TestAddAPlant;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Intent intent = getIntent();
        setContentView(R.layout.activity_display_message);
        /******************************************/
        /************WEATHER BUTTON****************/
        /******************************************/
        Button btnWeatherScreen = (Button) findViewById(R.id.btnWeatherScreen);
        btnWeatherScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent


                /****************************/
                /* ADD A PLANT TESTING STUFF */
                /****************************/

                // This is what is used to do
                //Intent nextScreen = new Intent(getApplicationContext(), WeatherActivity.class);

                //changed to this for parse testing stuff
                Intent nextScreen = new Intent(getApplicationContext(), TestAddAPlant.class);


                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });


        /******************************************/
        /************Add a Plant Button****************/
        /******************************************/
        Button btnAddPlant = (Button) findViewById(R.id.btnAddPlant);
        btnAddPlant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddPlant.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });
        /****************************************************/
        /************Watering Schedule Button****************/
        /****************************************************/
        Button btnWateringScheduleActivity = (Button) findViewById(R.id.wateringSchedule);
        btnWateringScheduleActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), WateringScheduleActivity.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });
        /*********************************************/
        /************Plant List Button****************/
        /*********************************************/
        Button btnPlantListActivity = (Button) findViewById(R.id.plantList);
        btnPlantListActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), PlantListActivity.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });

    }

    public void sendMessage1(View view) {
    }

    public void sendMessage2(View view) {
    }

    public void sendMessage3(View view) {
    }

    public void sendMessage4(View view) {
    }


}

