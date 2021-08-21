package com.example.digicare.patients;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.digicare.R;

import java.util.ArrayList;

public class TreatmentsLogAdapter extends RecyclerView.Adapter<TreatmentsLogAdapter.myViewHolder>{

    ArrayList<String> drNameList, drTypeList, drAddressList, visitDateList;
    Context ctx;

    public TreatmentsLogAdapter(Context ctx, ArrayList<String> drNameList, ArrayList<String> drTypeList, ArrayList<String> drAddressList, ArrayList<String> visitDateList) {
        this.drNameList = drNameList;
        this.drTypeList = drTypeList;
        this.drAddressList = drAddressList;
        this.visitDateList = visitDateList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.treatments_log_list_item, parent, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TreatmentsLogAdapter.myViewHolder holder, int position) {
        holder.drName.setText(drNameList.get(position));
        holder.drType.setText(drTypeList.get(position));
        holder.drAddress.setText(drAddressList.get(position));
        holder.visitDate.setText(visitDateList.get(position));
    }

    @Override
    public int getItemCount() {
        return drNameList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView drName, drType, drAddress, visitDate;
        ImageView call, message, email, whatsapp;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            drName = itemView.findViewById(R.id.tvDrName);
            drType = itemView.findViewById(R.id.tvDrSpecialisation);
            drAddress = itemView.findViewById(R.id.tvDrAddress);
            visitDate = itemView.findViewById(R.id.tvVisitDate);

            call = itemView.findViewById(R.id.callDrBtn);
            message = itemView.findViewById(R.id.messageDrBtn);
            email = itemView.findViewById(R.id.emailDrBtn);
            whatsapp = itemView.findViewById(R.id.whatsappDrBtn);

        }
    }
}
