package com.example.thinkpad.myfirstapp.MainMenuActivities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thinkpad.myfirstapp.R;
import com.example.thinkpad.myfirstapp.data.Channel;
import com.example.thinkpad.myfirstapp.data.Item;
import com.example.thinkpad.myfirstapp.WeatherService.WeatherServiceCallback;
import com.example.thinkpad.myfirstapp.WeatherService.YahooWeatherService;

public class WeatherActivity extends AppCompatActivity implements WeatherServiceCallback {

    public static int temperature;

    //Changed default city to Austin Tx
    private String USER_CITY;
    private String DEFAULT_CITY = "Austin, TX";
    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;


    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //can save the content view too
        setContentView(R.layout.activity_weather);


        /*****************************************************************/
        /**************ALLOW USER TO SAVE CITY INFORMATION****************/
        /*****************************************************************/
        //obtain a reference to the SharedPreferences file, private so data is not accessible
        //outside of the app
        SharedPreferences settings = getSharedPreferences("UserSettings", Context.MODE_PRIVATE);
        //editor object is the object that actually saves the data, open settings to be edited
        final SharedPreferences.Editor editor = settings.edit();
        //load the last city entered, default if no last city entered
        String lastCityEntered = settings.getString("lastCityUsed", DEFAULT_CITY);

        //check if there is a previous city entered
        if(lastCityEntered.equals(DEFAULT_CITY)){
            Toast.makeText(this, "Using default city...", Toast.LENGTH_LONG).show();
            //otherwise set the city to the default city
            USER_CITY = DEFAULT_CITY;

        } else {
            Toast.makeText(this, "Last city loaded successfully...", Toast.LENGTH_LONG).show();
            USER_CITY = lastCityEntered;
        }
        //final String defaultLocation = "San Diego, CA";
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
        service.refreshWeather(USER_CITY);
        //capture user city FORMAT: "City, State" Ex: "Los Angeles, CA"
        //Obtain a references to views desired
        final EditText editLocation = (EditText) findViewById(R.id.locationInput);
        final TextView locationView = (TextView)findViewById(R.id.locationTextView);

        /*******************************************************/
        /**************ALLOW USER TO UPDATE CITY****************/
        /*******************************************************/
        editLocation.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //get the new input
                USER_CITY = editLocation.getText().toString();
                //resent the query on new input received
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    changeCity(USER_CITY);

                    /* Save the changes to the SharedPreferences object */
                    editor.putString("lastCityUsed", USER_CITY);
                    editor.commit();
                    //clear the old input
                    editLocation.setText("");
                    return false;
                }
                return false;
            }
        });

    }

    /*-------------------------------------------------------------------*/
    /*-----------Mitch's old crappy code for saving state ---------------*/
    /*-------------------------------------------------------------------*/

    /*
    //saves the city entered by the user (can save other data too)
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString(USER_CITY, USER_CITY);
        //MORE DATA HERE
        //savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        //boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
        //double myDouble = savedInstanceState.getDouble("myDouble");
        //int myInt = savedInstanceState.getInt("MyInt");
        USER_CITY = savedInstanceState.getString("USER_CITY");
    }
    */


    //FUNCTION THAT CALLS REFRESH WEATHER FROM YAHOO SERVICE
    public void changeCity(String city){
        service.refreshWeather(city);
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

        temperature = item.getCondition().getTemperature();
    }
    /* This function runs when we fail to query yahoo */
    @Override
    public void serviceFailure(Exception exception) {
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
