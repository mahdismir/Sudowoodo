package com.example.thinkpad.myfirstapp.authenticator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thinkpad.myfirstapp.MainMenuActivity;
import com.example.thinkpad.myfirstapp.R;
import com.parse.ParseUser;


/**
 * This activity checks to see whether or not a user is already logged in when they start the app.
 * First checks the ParseUser object to see if there's a user logged in, if there is, then we
 * display the main menu while loading up users plants. Otherwise we ask them to login.
 */
public class DispatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
        //check if there is current user info
        //Parse.enableLocalDatastore(this);
        //Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_id));
        if(ParseUser.getCurrentUser() != null){
            // Start an intent for the logged in activity
            startActivity(new Intent(this, MainMenuActivity.class));
            finish();
        } else {
            // Start an intent for the logged out activity
            startActivity(new Intent(this, SignUpOrLoginActivity.class));
        }
    }

}
