package com.example.thinkpad.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class AddPlant extends AppCompatActivity {


    private Button MossButton;
    private Button FernButton;
    private Button coniferButton;
    private Button floweringButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_add_a_new_plant);




        Button btnAddMoss = (Button) findViewById(R.id.mossbtn);
        btnAddMoss.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddMoss.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });


        Button btnAddConifer = (Button) findViewById(R.id.coniferbtn);
        btnAddConifer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddConifer.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });




        Button btnAddFlowering = (Button) findViewById(R.id.Floweringbtn);
        btnAddFlowering.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddFlowering.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });



        Button btnAddFern = (Button) findViewById(R.id.Fernbtn);
        btnAddFern.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddFern.class);

                //Sending data to another Activity
                //nextScreen.putExtra("name", inputName.getText().toString());
                //nextScreen.putExtra("email", inputEmail.getText().toString());

                //Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
  /*      MossButton = (Button)findViewById(R.id.mossbtn);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
