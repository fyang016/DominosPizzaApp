package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class StoreList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contact> list = new ArrayList<Contact>();
    int[] image_id = {R.drawable.store1,R.drawable.store2,R.drawable.store3,R.drawable.store4,
            R.drawable.store5,R.drawable.store6,R.drawable.store7,R.drawable.store8,R.drawable.store9,
            R.drawable.store10,};
    String[] address, phone, hours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
        address = getResources().getStringArray(R.array.store_address);
        phone = getResources().getStringArray(R.array.store_phone);
        hours = getResources().getStringArray(R.array.store_hours);

        int count = 0;

        for(String Address : address) {
            Contact contact = new Contact(image_id[count],Address,phone[count],hours[count]);
            count++;
            list.add(contact);
        }
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ContactAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    public void gotoGoogleMaps(View view)
    {
        startActivity(new Intent(getApplicationContext(),GoogleMaps.class));
    }
}
