package com.example.thinkpad.myfirstapp.WeatherService;

import com.example.thinkpad.myfirstapp.data.Channel;

/**
 * Created by mitch_000 on 11/4/2015.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
