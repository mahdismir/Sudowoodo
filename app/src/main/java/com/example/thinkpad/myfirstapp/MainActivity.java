package com.example.thinkpad.myfirstapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import com.example.thinkpad.myfirstapp.MainMenuActivities.WeatherActivity;
import com.example.thinkpad.myfirstapp.authenticator.DispatchActivity;
import com.parse.ParseUser;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {


    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*****************************************/
        /********** FORCE PORTRAIT MODE **********/
        /*****************************************/
        //Changed all of the activities in the manifest to only display in portrait mode. (See activity manifest file)
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ParseUser.getCurrentUser().logOut();


        // This is for notifications.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        int i = preferences.getInt("numberOfLaunches", 1);

        if(i < 2){
            i++;
            editor.putInt("numberOfLaunches", i);
            editor.commit();
            alarmMethod();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on
        // the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            ParseUser.getCurrentUser().logOut();
            startActivity(new Intent(MainActivity.this, DispatchActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /****************************************************/
    /********** DISPLAY NOTIFICATIONS ACTIVITY **********/
    /****************************************************/
    private void alarmMethod(){

        Long alertTime = new GregorianCalendar().getTimeInMillis()+5*1000;

        Intent alertIntent = new Intent(this, AlertReceiver.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alertIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Calendar alarmCalendar = Calendar.getInstance();
        alarmCalendar.set(Calendar.SECOND,0);
        alarmCalendar.set(Calendar.MINUTE, 0);
        alarmCalendar.set(Calendar.HOUR, 12);
        alarmCalendar.set(Calendar.AM_PM, Calendar.PM);
        alarmCalendar.add(Calendar.DAY_OF_MONTH, 1);


        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmCalendar.getTimeInMillis(),
                1000*60*60*24, PendingIntent.getBroadcast(this, 1, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }


    public void sendMessage(View view) {
        Intent intent = new Intent(this, DispatchActivity.class);
        startActivity(intent);
        finish();
    }
}

