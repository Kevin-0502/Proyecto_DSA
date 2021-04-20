package com.example.dentistapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ContactosViewHolder> {
    ArrayList<ContactsModel> contactsModels;
    Context context;

    public RecyclerAdapter(ArrayList<ContactsModel> contactsModel, Context context) {
        this.contactsModels = contactsModel;
        this.context = context;
    }

    public void phoneDialer(String phone_number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phone_number));
        context.startActivity(intent);
    }


    @NonNull
    @Override
    public ContactosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_dentist_contacts, parent, false);
        return new ContactosViewHolder(row);

    }

    @Override
    public void onBindViewHolder(ContactosViewHolder holder, final int position) {
        ContactsModel contactModel = contactsModels.get(position);

        Picasso.get().load(contactModel.getImg()).into(holder.imageMembers);
        holder.memberName.setText(contactModel.getName());
        holder.memberTel.setText(contactModel.getTel());
        holder.btnDial.setOnClickListener(v -> phoneDialer(contactModel.getTel()));
    }

    @Override
    public int getItemCount() {
        return contactsModels.size();
    }

    public static class ContactosViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageMembers;
        private TextView memberName;
        private TextView memberTel;
        private ImageButton btnDial;

        public ContactosViewHolder(View itemView) {
            super(itemView);
            imageMembers = (ImageView) itemView.findViewById(R.id.member_picture);
            memberName = (TextView) itemView.findViewById(R.id.tv_lista_contactos);
            memberTel = (TextView) itemView.findViewById(R.id.tv_tel);
            btnDial = (ImageButton) itemView.findViewById(R.id.btn_dial);
        }
    }
}
