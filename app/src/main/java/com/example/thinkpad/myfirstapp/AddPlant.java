package com.example.thinkpad.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AddPlant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_add_a_new_plant);

        Button btnAddTemperate = (Button) findViewById(R.id.temperatebtn);
        btnAddTemperate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddTemperate.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });


        Button btnAddDesert = (Button) findViewById(R.id.desertbtn);
        btnAddDesert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddDesert.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });



        Button btnAddCool = (Button) findViewById(R.id.coolbtn);
        btnAddCool.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddCool.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });



        Button btnAddTropical = (Button) findViewById(R.id.Tropicalbtn);
        btnAddTropical.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddTropical.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });


    }

}
