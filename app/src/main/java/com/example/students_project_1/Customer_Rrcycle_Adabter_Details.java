package com.example.students_project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Customer_Rrcycle_Adabter_Details extends RecyclerView.Adapter<Customer_Rrcycle_Adabter_Details.MyHolder> {
    Context context;
    ArrayList<Detials> data;

    public Customer_Rrcycle_Adabter_Details(Context context, ArrayList<Detials> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_details, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.tv_avg.setText(data.get(position).getAvg());
        holder.cb_subject.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_avg;
        CheckBox cb_subject;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            cb_subject = itemView.findViewById(R.id.cb_subject);
            tv_avg = itemView.findViewById(R.id.tv_avg);
        }
    }
}
