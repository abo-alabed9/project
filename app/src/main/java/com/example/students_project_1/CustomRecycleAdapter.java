package com.example.students_project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecycleAdapter extends RecyclerView.Adapter<CustomRecycleAdapter.MyHolder> {
    Context context;
    ArrayList<Months> data;
   onItemClickListener listener;

    public CustomRecycleAdapter(Context context, ArrayList<Months> data, onItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_months,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.tv_id.setText(data.get(position).getId());
        holder.tv_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(holder.getAdapterPosition(),holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }






    public class MyHolder extends RecyclerView.ViewHolder{

        TextView tv_id;

        public MyHolder(@NonNull View itemView) {
            super(itemView);


            tv_id=itemView.findViewById(R.id.tv_id);
        }
    }

    interface onItemClickListener{
        void onClick(int months, int position);
    }


}
