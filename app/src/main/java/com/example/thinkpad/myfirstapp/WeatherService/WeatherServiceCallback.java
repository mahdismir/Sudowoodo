package com.example.thinkpad.myfirstapp.WeatherService;

import com.example.thinkpad.myfirstapp.data.Channel;

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}