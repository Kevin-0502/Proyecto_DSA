package com.example.dentistapp;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dentistapp.model.DateInfo;
import com.example.dentistapp.utils.AuthUtils;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BaseServiceFragment extends Fragment {

    protected final Calendar dateCalendar = Calendar.getInstance();
    protected EditText dateInput;
    protected EditText timeInput;

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
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dateInput = (EditText) view.findViewById(R.id.date_input);
        timeInput = (EditText) view.findViewById(R.id.time_input);

        dateInput.setOnClickListener(v -> {
            new DatePickerDialog(getContext(), dateListener, dateCalendar
                    .get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH),
                    dateCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        timeInput.setOnClickListener(v -> {
            new TimePickerDialog(getContext(), timeListener, dateCalendar
                    .get(Calendar.HOUR_OF_DAY), dateCalendar.get(Calendar.MINUTE), false).show();
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