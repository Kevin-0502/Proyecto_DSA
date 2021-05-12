package com.example.dentistapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dentistapp.model.DateInfo;
import com.example.dentistapp.utils.AuthUtils;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Service4Fragment extends BaseServiceFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_service4, container, false);

        Button scheduleButton = (Button) rootView.findViewById(R.id.schedule_button);

        scheduleButton.setOnClickListener(view -> {
            FirebaseUser user = AuthUtils.getUser();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("services").child(user.getUid());

            DateInfo info = new DateInfo(dateCalendar.getTimeInMillis(), "Servicios de limpieza dental");
            DatabaseReference dateReference = databaseReference.push();
            dateReference.setValue(info);

            Toast.makeText(getContext(), "Date Scheduled!", Toast.LENGTH_SHORT).show();
        });

        return rootView;
    }
}


