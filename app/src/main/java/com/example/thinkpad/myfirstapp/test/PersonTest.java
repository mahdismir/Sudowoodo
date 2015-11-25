package com.example.thinkpad.myfirstapp.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.thinkpad.myfirstapp.data.Person;
import com.example.thinkpad.myfirstapp.R;

public class PersonTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Person currentPerson = new Person();
        currentPerson.getPlantsFromParse();

    }

}
