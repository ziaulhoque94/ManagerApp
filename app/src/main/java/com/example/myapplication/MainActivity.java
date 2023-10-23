package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText date, detail, ammount;

    MySqLiteHelper databaseHelper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date=(EditText) findViewById(R.id.dateId);
        detail=(EditText) findViewById(R.id.costID);
        ammount=(EditText) findViewById(R.id.totalID);

        databaseHelper=new MySqLiteHelper(this);

    }

    public void ShowAllActivity(View view) {
        startActivity(new Intent(MainActivity.this, DailyInfoActivity.class));
    }

    public void AddInfo(View view) {
        if (date.getText().toString().isEmpty()){
            date.setError("Date box error..");
        }else if (detail.getText().toString().isEmpty()){
            detail.setError("Details box error..");
        }else if (!ammount.getText().toString().isEmpty()){
            ammount.setError("Amount box error..");
        }

        databaseHelper=new MySqLiteHelper(this);
        String date1=date.getText().toString();
        String detailsAll=detail.getText().toString();
        int total=Integer.parseInt(ammount.getText().toString());

        databaseHelper.isInserted(date1,detailsAll,total);
        Toast.makeText(getApplicationContext(), "Entry success",Toast.LENGTH_LONG).show();
        date.setText("");
        detail.setText("");
        ammount.setText("");
    }

    public void ModifiedData(View view) {
        databaseHelper=new MySqLiteHelper(this);
        String date1=date.getText().toString();
        String detailsAll=detail.getText().toString();
        int total=Integer.parseInt(ammount.getText().toString());

        databaseHelper.isModified(date1,detailsAll,total);
        Toast.makeText(getApplicationContext(), "Modification hase been change",Toast.LENGTH_LONG).show();
        date.setText("");
        detail.setText("");
        ammount.setText("");
    }


    public void OnDateEditeTextClick(View view) {
        // on below line we are getting
        // the instance of our calendar.
        final Calendar c = Calendar.getInstance();

        // on below line we are getting
        // our day, month and year.
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        // on below line we are creating a variable for date picker dialog.
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
            }
        }, year, month, day);
        datePickerDialog.show();

    }

    public void DeleteDataMethod(View view) {
        if (ammount.getText().toString().isEmpty()){
            ammount.setError("Text Delete Ammount");
        }else{
            String dDate=ammount.getText().toString();
            MySqLiteHelper mySqLiteHelper=new MySqLiteHelper(this);
            mySqLiteHelper.isDeleted(dDate);
            Toast.makeText(this, "Delete success", Toast.LENGTH_SHORT).show();
        }
    }

    public void ClearDataMethod(View view) {
//        String dDate=date.getText().toString();
//        String dDetails=detail.getText().toString();
//        int dAmmount=Integer.parseInt(ammount.getText().toString());
//
        if (!date.getText().toString().isEmpty()){
            date.setText("");
        }else if (!detail.getText().toString().isEmpty()){
            detail.setText("");
        }else if (!ammount.getText().toString().isEmpty()){
            ammount.setText("");
        }


    }
}