package com.example.dentistapp;

import android.app.ActionBar;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    String urlJson;
    ArrayList<ContactsModel> contactsModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);


        Resources res = this.getResources();
        urlJson = res.getString(R.string.url_json);

        initContentLocal();
    }

    private void initContentLocal() {

        ContactsModel nathieContact = new ContactsModel("Dr. Trevor Baret", "60237569", R.drawable.dentista1);
        ContactsModel babyContact = new ContactsModel("Dr. Ruby Wang", "77453293", R.drawable.dentista2);
        ContactsModel jazminContact = new ContactsModel("Dr. Wilbert Zulueta", "76055255", R.drawable.dentista3);
        ContactsModel carlosContact = new ContactsModel("Dr. Marcia Okada", "72394044", R.drawable.dentista4);


        contactsModels.add(new ContactsModel("Dr. Marcelle Girgis", "77006408", R.drawable.dentista5));
        contactsModels.add(nathieContact);
        contactsModels.add(babyContact);
        contactsModels.add(jazminContact);
        contactsModels.add(carlosContact);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvContactos);
        recyclerView.setAdapter(new RecyclerAdapter(contactsModels, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Drawable mDivider = ContextCompat.getDrawable(this, R.drawable.divider);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        if (mDivider != null) {
            itemDecoration.setDrawable(mDivider);
        }


        recyclerView.addItemDecoration(itemDecoration);


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}