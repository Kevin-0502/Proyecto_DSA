package com.example.dentistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button servicesBtn = (Button) findViewById(R.id.servicesbtn);
        Button contactBtn = (Button) findViewById(R.id.contactid);
        Button tipsBtn = (Button) findViewById(R.id.tipsid);
        Button mapBtn = (Button) findViewById(R.id.locationid);
        Button scheduleVirtualdateBtn = (Button) findViewById(R.id.scheduledateid);
        Button myAppointmentsBtn = (Button) findViewById(R.id.myappointmentsid);

        servicesBtn.setOnClickListener(mainListener);
        contactBtn.setOnClickListener(mainListener);
        tipsBtn.setOnClickListener(mainListener);
        mapBtn.setOnClickListener(mainListener);
        scheduleVirtualdateBtn.setOnClickListener(mainListener);
        myAppointmentsBtn.setOnClickListener(mainListener);

    }

    private void openServicesActivity() {
        Intent intent = new Intent(this, DisplayServicesActivity.class);
        startActivity(intent);
    }

    private void openContactActivity() {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }

    private void openTipsActivity() {
        Intent intent = new Intent(this, DisplayTipsActivity.class);
        startActivity(intent);
    }

    private void openVirtualAppointmentActivity() {
        Intent intent = new Intent(this, VirtualAppointmentActivity.class);
        startActivity(intent);
    }

    private void openHistoryActivity() {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }


    private View.OnClickListener mainListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.servicesbtn:
                    openServicesActivity();
                    break;
                case R.id.contactid:
                    openContactActivity();
                    break;
                case R.id.tipsid:
                    openTipsActivity();
                    break;
                case R.id.scheduledateid:
                    openVirtualAppointmentActivity();
                    break;
                case R.id.myappointmentsid:
                    openHistoryActivity();
                    break;
                case R.id.locationid:
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=13.7155129,-89.2142973(Dentist)");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }
                    break;
            }
        }
    };
}