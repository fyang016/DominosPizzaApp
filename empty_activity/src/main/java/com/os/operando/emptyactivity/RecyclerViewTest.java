package com.os.operando.emptyactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewTest extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("412 Chicago Ave\nRiverside, CA 92507");
        arrayList.add("4100 Central Ave. Unit 105\nRiverside, CA");
        arrayList.add("22583 Barton Road\nGrand Terrace, CA 92324");
        arrayList.add("19510 Van Buren Blvd\nRiverside, CA 92508");
        arrayList.add("229 W. Valley Blvd.\nColton, CA 92324");
        arrayList.add("24578 Alessandro Blvd\nMoreno Valley, CA 92553");
        arrayList.add("1377 S Lilac Ave Ste 101\nBloomington, CA 92316");
        arrayList.add("8300 Limonite Ave Suite H\nRiverside, CA 92509");
        arrayList.add("2915 Van Burn Blcd Suite J-2\nRiverside, CA 92504");


        recyclerView.setAdapter(new RecyclerAdapter(arrayList));

    }
}
