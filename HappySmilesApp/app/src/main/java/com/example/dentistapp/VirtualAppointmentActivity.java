package com.example.dentistapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dentistapp.model.DateInfo;
import com.example.dentistapp.utils.AuthUtils;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class VirtualAppointmentActivity extends AppCompatActivity {

    private final Calendar dateCalendar = Calendar.getInstance();
    private EditText dateInput;
    private EditText timeInput;

    DatePickerDialog.OnDateSetListener dateListener = (view, year, monthOfYear, dayOfMonth) -> {
        dateCalendar.set(Calendar.YEAR, year);
        dateCalendar.set(Calendar.MONTH, monthOfYear);
        dateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateDateInput();
    };

    TimePickerDialog.OnTimeSetListener timeListener = (view, hourOfDay, minute) -> {
        dateCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        dateCalendar.set(Calendar.MINUTE, minute);
        updateTimeInput();
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtualappointment);

        dateInput = (EditText) findViewById(R.id.date_input);
        timeInput = (EditText) findViewById(R.id.time_input);
        Button scheduleButton = (Button) findViewById(R.id.schedule_button);

        dateInput.setOnClickListener(v -> {
            new DatePickerDialog(this, dateListener, dateCalendar
                    .get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH),
                    dateCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        timeInput.setOnClickListener(v -> {
            new TimePickerDialog(this, timeListener, dateCalendar
                    .get(Calendar.HOUR_OF_DAY), dateCalendar.get(Calendar.MINUTE), false).show();
        });

        scheduleButton.setOnClickListener(view -> {
            FirebaseUser user = AuthUtils.getUser();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("services").child(user.getUid());

            DateInfo info = new DateInfo(dateCalendar.getTimeInMillis(), "Cita virtual");
            DatabaseReference dateReference = databaseReference.push();
            dateReference.setValue(info);

            Toast.makeText(this, "Date Scheduled!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void updateTimeInput() {
        String timeFormat = "hh:mma";
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat, Locale.US);

        timeInput.setText(sdf.format(dateCalendar.getTime()));
    }

    private void updateDateInput() {
        String dateFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);

        dateInput.setText(sdf.format(dateCalendar.getTime()));
    }
}
