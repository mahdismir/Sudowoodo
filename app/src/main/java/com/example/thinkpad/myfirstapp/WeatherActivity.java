package com.example.thinkpad.myfirstapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thinkpad.myfirstapp.data.Channel;
import com.example.thinkpad.myfirstapp.data.Item;
import com.example.thinkpad.myfirstapp.service.WeatherServiceCallback;
import com.example.thinkpad.myfirstapp.service.YahooWeatherService;

public class WeatherActivity extends AppCompatActivity implements WeatherServiceCallback {


    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;


    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        /* instantiate the instance variables */
        weatherIconImageView = (ImageView)findViewById(R.id.weatherIconImageView);
        temperatureTextView = (TextView)findViewById(R.id.temperatureTextView);
        conditionTextView =  (TextView)findViewById(R.id.conditionTextView);
        locationTextView =  (TextView)findViewById(R.id.locationTextView);

        /* Invoke the yahoo weather service */
        service = new YahooWeatherService(this);
        //populate the dialog
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        service.refreshWeather("Bell Gardens, CA");
    }

    /* This function is run when we successfully query the yahoo database for weather info */
    @Override
    public void serviceSuccess(Channel channel) {
        //hides the loading dialog since service is done
        dialog.hide();

        Item item = channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());
        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);

        weatherIconImageView.setImageDrawable(weatherIconDrawable);
        temperatureTextView.setText(item.getCondition().getTemperature() + "\u00B0 " + channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(service.getLocation());
    }
    /* This function runs when we fail to query yahoo */
    @Override
    public void serviceFailure(Exception exception) {
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
