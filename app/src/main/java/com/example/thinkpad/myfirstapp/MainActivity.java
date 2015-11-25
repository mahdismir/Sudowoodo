package com.example.thinkpad.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import com.example.thinkpad.myfirstapp.authenticator.DispatchActivity;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*************************************************/
        /**************FORCE PORTRAIT MODE****************/
        /*************************************************/
        //Mitch: I changed all of the activities in the manifest
        //to only display in portrait mode. (See activity manifest file)
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ParseUser.getCurrentUser().logOut();

        /******************************************************/
        /**************parse database stuff WIP****************/
        /******************************************************/
        // Enable Local Datastore for user/plant management
        //Parse.enableLocalDatastore(this);
        //Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_id));




        // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        // });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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
            ParseUser.getCurrentUser().logOut();
            startActivity(new Intent(MainActivity.this, DispatchActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /******************************************************/
    /***********DISPLAY MAIN MENU ACTIVITY*****************/
    /******************************************************/
    /*


    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainMenuActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    */
    /**************************************************/
    /***********DISPLAY LOGIN ACTIVITY*****************/
    /**************************************************/
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DispatchActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        finish();
    }



    /************************************************/
    /***************SAVED STATE CODE*****************/
    /************************************************/
    //@Override
    //protected void OnSave
}

