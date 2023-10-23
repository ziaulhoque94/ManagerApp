package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RV_CustomAdaptar extends RecyclerView.Adapter<RV_CustomAdaptar.MyHolder>{

    Context context;
    ArrayList<InfoModal> arrayList;

    public RV_CustomAdaptar(Context context, ArrayList<InfoModal> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_list,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        InfoModal infoModal=arrayList.get(position);

        holder.date.setText(infoModal.getDate());
        holder.details.setText(infoModal.getDetails());
        holder.ammount.setText("Total ="+infoModal.getAmmount());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView date, details, ammount;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.cDateId);
            details=itemView.findViewById(R.id.cDetailsID);
            ammount=itemView.findViewById(R.id.cTotalId);
        }
    }
}
