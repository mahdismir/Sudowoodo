package com.example.thinkpad.myfirstapp.authenticator;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thinkpad.myfirstapp.R;
import com.parse.Parse;
import com.parse.ParseUser;
//import android.app.Application;

/**
 * Created by mitch_000 on 11/22/2015.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore for user/plant management

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_id));

    }
}
