package com.example.thinkpad.myfirstapp.data;

import org.json.JSONObject;

/**
 * Created by mitch_000 on 11/4/2015.
 */
public class Units implements JSONPopulator {
    private String temperature;

    public String getTemperature() {
        return temperature;
    }


    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");

    }
}
