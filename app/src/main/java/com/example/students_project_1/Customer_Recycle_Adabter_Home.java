package com.example.students_project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Customer_Recycle_Adabter_Home extends RecyclerView.Adapter<Customer_Recycle_Adabter_Home.MyHolder> {

    Context context;
    ArrayList<Home> data;
    onItemClickListener listener;


    public Customer_Recycle_Adabter_Home(Context context, ArrayList<Home> data,onItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

       holder.tv_name.setText(data.get(position).getTv_name());
       holder.img_delete.setImageResource(data.get(position).getImg());

       holder.tv_name.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.onClick(data.get(holder.getAdapterPosition()),holder.getAdapterPosition());
           }
       });

       holder.img_delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.onDeleteClick(holder.getAdapterPosition());
           }
       });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        ImageView img_delete;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tv_name=itemView.findViewById(R.id.tv_name);
            img_delete=itemView.findViewById(R.id.image_delete);
        }
    }
    interface onItemClickListener{
        void onClick(Home home,int position);
        void onDeleteClick(int  position);
    }
}
