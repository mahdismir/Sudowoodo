package com.example.thinkpad.myfirstapp.authenticator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.thinkpad.myfirstapp.R;

public class SingleItemView extends Activity {
    // Declare Variables
    String nickname;
    String type;
    String lastWatered;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.activity_single_item_view);

        Intent i = getIntent();
        // Get the result of rank
        nickname = i.getStringExtra("nickname");
        // Get the result of country
        type = i.getStringExtra("type");
        // Get the result of population
        lastWatered = i.getStringExtra("lastWatered");


        // Locate the TextViews in singleitemview.xml
        TextView txtnickname = (TextView) findViewById(R.id.nickname_label);
        TextView txttype = (TextView) findViewById(R.id.type_label);
        TextView txtlastWatered = (TextView) findViewById(R.id.last_watered_label);


        // Set results to the TextViews
        txtnickname.setText(nickname);
        txttype.setText(type);
        txtlastWatered.setText(lastWatered);



    }
}