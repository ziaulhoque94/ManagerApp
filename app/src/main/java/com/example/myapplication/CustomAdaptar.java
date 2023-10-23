package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptar extends BaseAdapter {
    Context context;
    ArrayList<Modal> arrayList;

    public CustomAdaptar(Context context, ArrayList<Modal> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.custom_list, parent, false);
        }
        Modal modal=(Modal) getItem(position);


        TextView id, date, details, ammount2;
        date=convertView.findViewById(R.id.cDateId);
        details=convertView.findViewById(R.id.cDetailsID);
        ammount2=convertView.findViewById(R.id.cTotalId);

//        int count=0;
//        count=count+1;
//        id.setText(count);
        date.setText(modal.getDate());
        details.setText(modal.getDetails());
        ammount2.setText(modal.getAmmount());

        return convertView;
    }
}
