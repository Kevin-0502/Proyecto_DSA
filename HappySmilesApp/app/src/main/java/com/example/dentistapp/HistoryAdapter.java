package com.example.dentistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentistapp.model.DateInfo;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HistoryAdapter extends FirebaseRecyclerAdapter<DateInfo, HistoryAdapter.HistoryHolder> {

    public HistoryAdapter(@NonNull FirebaseRecyclerOptions<DateInfo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull HistoryHolder holder, int position, @NonNull DateInfo model) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(model.getDate());

        String dateFormat = "MM/dd/yy";
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat, Locale.US);

        String timeFormat = "hh:mma";
        SimpleDateFormat timeFormatter = new SimpleDateFormat(timeFormat, Locale.US);

        holder.date.setText(dateFormatter.format(calendar.getTime()));
        holder.time.setText(timeFormatter.format(calendar.getTime()));
        holder.type.setText(model.getDateType());
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryHolder(view);
    }

    static class HistoryHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView time;
        TextView type;

        public HistoryHolder(@NonNull View root) {
            super(root);
            this.date = (TextView) root.findViewById(R.id.item_date);
            this.time = (TextView) root.findViewById(R.id.item_time);
            this.type = (TextView) root.findViewById(R.id.item_service);
        }
    }
}
