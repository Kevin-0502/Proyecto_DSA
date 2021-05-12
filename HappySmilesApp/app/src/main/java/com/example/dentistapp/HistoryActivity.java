package com.example.dentistapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentistapp.utils.AuthUtils;
import com.example.dentistapp.model.DateInfo;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class HistoryActivity extends AppCompatActivity {

    private HistoryAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.history_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        //If user is authenticated, we can access the history items.
        if (AuthUtils.isAuthenticated()) {
            FirebaseUser user = AuthUtils.getUser();
            Query query = FirebaseDatabase.getInstance().getReference("services").child(user.getUid());

            FirebaseRecyclerOptions<DateInfo> options = getRecyclerOptions(query);

            adapter = new HistoryAdapter(options);
            recyclerView.setAdapter(adapter);
        }
    }

    /**
     * Recycler options to load history items
     *
     * @param query Firebase Query pointing to the user specific history
     * @return FirebaseRecyclerOptions
     */
    private FirebaseRecyclerOptions<DateInfo> getRecyclerOptions(Query query) {
        return new FirebaseRecyclerOptions.Builder<DateInfo>()
                .setQuery(query, new SnapshotParser<DateInfo>() {
                    @NonNull
                    @Override
                    public DateInfo parseSnapshot(@NonNull DataSnapshot snapshot) {
                        return new DateInfo(Long.parseLong(snapshot.child("date").getValue().toString()),
                                snapshot.child("dateType").getValue().toString());
                    }
                })
                .build();
    }

    //Start listening to updates on firebase adapter
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    //Stop listening to updates on firebase adapter
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
