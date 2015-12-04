package com.example.thinkpad.myfirstapp.authenticator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.thinkpad.myfirstapp.R;

public class SignUpOrLoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_or_login);
        // Log in button click handler.
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            // Starts an intent of the log in activity.
            startActivity(new Intent(SignUpOrLoginActivity.this, LoginActivity.class));
            }
        });

        // Sign up button click handler.
        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            // Starts an intent for the sign up activity
            startActivity(new Intent(SignUpOrLoginActivity.this, SignUpActivity.class));
            }
        });
    }
}
