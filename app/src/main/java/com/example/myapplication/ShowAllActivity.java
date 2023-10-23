package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowAllActivity extends AppCompatActivity {

    ListView listView;
    CustomAdaptar adaptar;
    ArrayList<Modal> arrayList;
    MySqLiteHelper mySqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
//        try {
            listView=findViewById(R.id.listId);

        arrayList=new ArrayList<>();
        mySqLiteHelper=new MySqLiteHelper(this);

//        arrayList=mySqLiteHelper.ReadInfo();

//            Log.d("Respons", "onCreate: "+arrayList.toString());
            adaptar=new CustomAdaptar(this, arrayList);
            listView.setAdapter(adaptar);
//        }catch (NullPointerException $e){

//            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
//        }
       
    }
}