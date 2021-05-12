package com.example.dentistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AccessOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessoptions);

        Button logInOptionBtn = (Button) findViewById(R.id.logInOptionBtnId);
        Button signUpOptionBtn = (Button) findViewById(R.id.signUpOptionBtnId);

        logInOptionBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent (AccessOptionsActivity.this, LoginActivity.class));
            }
        });

        signUpOptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccessOptionsActivity.this, RegisterActivity.class));
            }
        });


    }
}
