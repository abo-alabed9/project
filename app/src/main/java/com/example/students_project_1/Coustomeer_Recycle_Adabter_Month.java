package com.example.students_project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Coustomeer_Recycle_Adabter_Month extends RecyclerView.Adapter<Coustomeer_Recycle_Adabter_Month.MyHplde> {

    Context context;
    ArrayList<Month> data;
    onItemClickListener listener;

    public Coustomeer_Recycle_Adabter_Month(Context context, ArrayList<Month> data, onItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyHplde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_month, parent, false);
        return new MyHplde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHplde holder, int position) {
        holder.btn_month.setText(data.get(position).getName());
        holder.btn_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(data.get(holder.getAdapterPosition()), holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHplde extends RecyclerView.ViewHolder {
        Button btn_month;

        public MyHplde(@NonNull View itemView) {
            super(itemView);
            btn_month = itemView.findViewById(R.id.btn_month);
        }
    }

    interface onItemClickListener {
        void onClick(Month month, int position);
    }
}
