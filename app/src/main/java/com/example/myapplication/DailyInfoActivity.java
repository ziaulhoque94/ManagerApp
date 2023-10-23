package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DailyInfoActivity extends AppCompatActivity {

    RV_CustomAdaptar rv_customAdaptar;
    ArrayList<InfoModal> modalArrayList;
    RecyclerView recyclerView;
    MySqLiteHelper mySqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_info);



        recyclerView=findViewById(R.id.showallID);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        modalArrayList=new ArrayList<>();
        mySqLiteHelper=new MySqLiteHelper(DailyInfoActivity.this);
        modalArrayList=mySqLiteHelper.ReadInfo();
//        modalArrayList.add(new InfoModal("10-29-21","dsjfkjshdf","9010"));
//        modalArrayList.add(new InfoModal("10-29-21","dsjfkjshdf","7820"));
//        modalArrayList.add(new InfoModal("10-29-21","dsjfkjshdf","2240"));


        rv_customAdaptar=new RV_CustomAdaptar(this,modalArrayList);

        recyclerView.setAdapter(rv_customAdaptar);

    }

}